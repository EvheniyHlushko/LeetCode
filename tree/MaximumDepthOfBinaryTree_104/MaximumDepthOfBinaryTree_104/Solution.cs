using System;

namespace MaximumDepthOfBinaryTree_104
{
//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

//    104. Maximum Depth of Binary Tree

//    Given a binary tree, find its maximum depth.

//    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

//    For example:
//    Given binary tree[3, 9, 20, null, null, 15, 7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
//    return its depth = 3.


  public class Solution
  {
    public int MaxDepth(TreeNode root)
    {
      return MaxDepthSolution(root);
    }

    public int MaxDepthSolution(TreeNode root)
    {
      if (root == null) return 0;

      var left_depth = MaxDepthSolution(root.left);
      var right_depth = MaxDepthSolution(root.right);
      return Math.Max(left_depth, right_depth) + 1;
    }
  }
}