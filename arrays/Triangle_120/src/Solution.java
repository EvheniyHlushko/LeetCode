import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return 0;
        }

        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }

        return calculate(triangle);
    }


    private Integer calculate(List<List<Integer>> triangle){

        Integer[] first = new Integer[]{triangle.get(0).get(0)};

        Integer[] result = calculate(first, triangle.get(1));

        for (int i = 2; i < triangle.size(); i++){
            result = calculate(result, triangle.get(i));
        }

        return getMinValue(result);
    }

    private Integer[] calculate(Integer[] first, List<Integer> second){
        Integer[] result = new Integer[second.size()];


        result[0] = first[0] + second.get(0);

        for (int i = 1; i < second.size() - 1; i++){
            int firstResult = first[i-1] + second.get(i);

            int secondResult = first[i] + second.get(i);
            result[i] = firstResult < secondResult ? firstResult : secondResult;
        }

        result[second.size() - 1] = first[first.length - 1] + second.get(second.size() - 1);

        return result;
    }


    private int getMinValue(Integer[] array){
        int minValue = array[0];

        for (int i = 1; i < array.length; i++){
            if(array[i] < minValue){
                minValue = array[i];
            }
        }

        return minValue;
    }
}
