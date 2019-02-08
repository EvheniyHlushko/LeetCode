import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
//    public int minSubArrayLen(int s, int[] nums) {
//        Arrays.sort(nums);
//
////        int[] newArray = Arrays.stream(nums)
////                .boxed()
////                .sorted(Comparator.reverseOrder())
////                .mapToInt(i -> i)
////                .toArray();
//
//
//
//        return calculate(nums, s, 0, 0);
//    }
//
//
//    private int calculate(int[] nums, int sum, int count, int start){
//        for (int i = start; i < nums.length; i++)
//        {
//            if(nums[i] >= sum){
//                count++;
//                return count;
//            }
//
//            if(nums[i] < sum){
//                return calculate(nums, sum - nums[start], ++count, ++start);
//            }
//        }
//
//        return 0;
//    }


    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

