/*
https://leetcode.com/problems/single-number/
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
/*
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> dic = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            int count = dic.containsKey(nums[i]) ? dic.get(nums[i]) : 0;
            dic.put(nums[i], count + 1);
        }

        for (int i = 0; i < nums.length; i++)
        {
            if(dic.get(nums[i]) == 1){
                return nums[i];
            }
        }
        return 0;
    }*/
public int singleNumber(int[] A) {
    if (A == null || A.length == 0) return 0;
    int num = 0 ;
    for (int i = 0 ; i < A.length; i ++){
        num = num ^ A[i];
    }
    return num;
}
}
