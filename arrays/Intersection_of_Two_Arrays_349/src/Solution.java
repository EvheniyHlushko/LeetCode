import java.util.ArrayList;
import java.util.HashSet;

/*

https://leetcode.com/problems/intersection-of-two-arrays/description/
Given two arrays, write a function to compute their intersection.

        Example 1:

        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2]
        Example 2:

        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [9,4]
        Note:

        Each element in the result must be unique.
        The result can be in any order.*/

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }

        HashSet set1 = populateHashSet(nums1);
        HashSet set2 = populateHashSet(nums2);

        Object[] array = set1.toArray();

        var result = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++){
            if(!set2.contains(array[i])){
                continue;
            }

            result.add((int)array[i]);
        }

        return result.stream().mapToInt(i->i).toArray();

    }

    private HashSet populateHashSet(int[] collection){
        HashSet set = new HashSet();
        for (int i = 0; i < collection.length; i++){
            set.add(collection[i]);
        }
        return set;
    }
}
