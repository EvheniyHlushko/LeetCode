import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/contains-duplicate/
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+ 1]){
                return true;
            }
        }
        return false;
    }
}
