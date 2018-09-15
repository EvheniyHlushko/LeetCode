import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {

        int diff = 0;

        int[] result = new int[2];

        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++){
            diff = target - nums[i];
            if(hash.containsKey(diff)){
                result[0] = hash.get(diff);
                result[1] = i;
                return result;
            }
            hash.put(nums[i], i);
        }

        return result;
    }

}
