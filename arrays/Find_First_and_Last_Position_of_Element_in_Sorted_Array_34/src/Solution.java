//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
//34. Find First and Last Position of Element in Sorted Array
//        Medium
//
//        1269
//
//        67
//
//        Favorite
//
//        Share
//        Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//        If the target is not found in the array, return [-1, -1].
//
//        Example 1:
//
//        Input: nums = [5,7,7,8,8,10], target = 8
//        Output: [3,4]
//        Example 2:
//
//        Input: nums = [5,7,7,8,8,10], target = 6
//        Output: [-1,-1]

public class Solution {
//    public int[] searchRange(int[] nums, int target) {
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++){
//            if(nums[i] == target){
//                result[0] = i;
//                i++;
//                while(i < nums.length && nums[i] == target){
//                    i++;
//                }
//                result[1] = i - 1;
//                return result;
//            }
//        }
//
//        return new int[]{-1,-1};
//    }


    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int[] result = new int[2];
        Integer idx = calculate(nums, target);

        if(idx == null){
            return new int[]{-1,-1};
        }
        result[0] = getStartIndex(nums, target, idx);
        result[1] = getEndIndex(nums, target, idx);

        return result;
      //  return new int[]{-1,-1};
    }

    private int getStartIndex(int[] nums, int target, int idx){
        if(idx == 0){
            return idx;
        }
        idx--;

        while(idx != -1 && nums[idx] == target){
          idx--;
        }

        return ++idx;
    }

    private int getEndIndex(int[] nums, int target, int idx){

        idx++;

        while(nums.length > idx && nums[idx] == target){
            idx++;
        }

        return --idx;
    }

    private Integer calculate(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;

        while(l <= r){
            int m = l + (r - l) / 2;

            if (arr[m] == x)
                return m;

            if (arr[m] < x)
                l = m + 1;

            else
                r = m - 1;
        }

        return null;
    }
}
