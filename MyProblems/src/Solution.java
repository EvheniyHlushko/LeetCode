import java.util.HashSet;

public class Solution {

    public int[] getPairs(int[] array, int sum){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] + array[j] == sum){
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[]{};
    }

    public int[] getPairs1(int[] array, int sum){
        HashSet<Integer> hashSet = new HashSet();

        for (int i = 0; i < array.length; i++) {
           int diff = sum - array[i];

           if(hashSet.contains(diff)){
               return new int[]{diff, array[i]};
           }
           hashSet.add(array[i]);
        }
        return new int[]{};
    }
}
