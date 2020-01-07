/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return GetTreeNode(nums, 0, nums.length - 1);
    }


    private TreeNode GetTreeNode(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (end + start) % 2 == 1 ? (end + start)/2 + 1 : (end + start)/2 ;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = GetTreeNode(nums, start, mid - 1);
        node.right = GetTreeNode(nums, mid + 1, end);

        return node;
    }
}


