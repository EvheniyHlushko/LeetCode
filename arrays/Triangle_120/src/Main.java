import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        Integer[] first = new Integer[]{2};

        Integer[] second = new Integer[]{3,4};
        Integer[] third = new Integer[]{6,5,7};
        Integer[] fourth = new Integer[]{4,1,8,3};

        List<List<Integer>> triangle = new ArrayList<>();


        triangle.add(Arrays.asList(first));
        triangle.add(Arrays.asList(second));
        triangle.add(Arrays.asList(third));
        triangle.add(Arrays.asList(fourth));

        int result = solution.minimumTotal(triangle);

        System.out.print(result);
    }
}
