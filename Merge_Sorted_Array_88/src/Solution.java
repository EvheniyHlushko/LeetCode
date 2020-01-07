/*
https://leetcode.com/problems/merge-sorted-array/
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        while (j < n && i < m + n) {
            int num1Value = nums1[i];
            int num2Value = nums2[j];
            if(nums1[i] > nums2[j] ){
                reorder(nums1, i, m + j);
                nums1[i] = nums2[j];
                j++;
            }
            else if(nums1[i] == 0 && i >= m+ j ){
                nums1[i] = nums2[j];
                j++;
            }

            i++;

        }


    }

    public void reorder(int[] nums, int index, int n) {

        int cur = nums[index];
        int next;
        while (index < nums.length ) {
            if(nums[index] == 0 && index >= n){
                nums[index] = cur;
                return;
            }
            next = nums[index];
            nums[index] = cur;
            cur = next;
            index++;
        }
    }
}
