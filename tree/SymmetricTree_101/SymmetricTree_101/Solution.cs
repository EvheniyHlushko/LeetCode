using System.Collections.Generic;
using System.Linq;

namespace SymmetricTree_101
{
//    https://leetcode.com/problems/symmetric-tree/description/

//    101. Symmetric Tree

//    Given a binary tree, check whether it is a mirror of itself(ie, symmetric around its center).

//    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
//    But the following[1, 2, 2, null, 3, null, 3] is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3

  public class Solution
  {
    public bool IsSymmetric(TreeNode root)
    {
      return root == null || IsSymmetricSolution(root.right, root.left);
    }

    public bool IsSymmetricSolution(TreeNode right, TreeNode left)
    {
      if (right == null && left == null) return true;

      if (right == null || left == null || right.val != left.val) return false;

      return IsSymmetricSolution(right.right, left.left) && IsSymmetricSolution(right.left, left.right);
    }


    public bool IsSymmetricIteratively(TreeNode root)
    {
      if (root == null) return true;

      var rightQueue = new Queue<TreeNode>();

      var leftQueue = new Queue<TreeNode>();

      var left = root.left;

      var right = root.right;

      leftQueue.Enqueue(left);

      rightQueue.Enqueue(right);

      if (left == null && right == null) return true;

      var isEqual = true;

      while (leftQueue.Count > 0)
      {
        var node1 = leftQueue.Dequeue();

        var node2 = rightQueue.Dequeue();

        isEqual = IsNodesEqual(node1, node2);

        if (!isEqual) break;

        var first = node1?.left != null || node2?.right != null;

        var second = node1?.right != null || node2?.left != null;

        if (first) leftQueue.Enqueue(node1?.left);

        if (second) leftQueue.Enqueue(node1?.right);


        if (first) rightQueue.Enqueue(node2?.right);

        if (second) rightQueue.Enqueue(node2?.left);

        if (leftQueue.All(x => x == null) && rightQueue.All(x => x == null)) break;
      }

      return isEqual;
    }


    private bool IsNodesEqual(TreeNode right, TreeNode left)
    {
      if (right == null && left == null) return true;

      if (right == null || left == null || right.val != left.val) return false;

      return true;
    }

    private bool CheckIfAllElemetsIsNull(List<TreeNode> list)
    {
      return list.All(x => x == null);
    }
  }
}