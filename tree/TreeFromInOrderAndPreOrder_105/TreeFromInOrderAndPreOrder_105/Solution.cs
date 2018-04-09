using System.Collections.Generic;
using System.Linq;

namespace TreeFromInOrderAndPreOrder_105
{
//    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

//    105. Construct Binary Tree from Preorder and Inorder Traversal

//    Given preorder and inorder traversal of a tree, construct the binary tree.

//    Note:
//    You may assume that duplicates do not exist in the tree.

//    For example, given

//    preorder = [3, 9, 20, 15, 7]
//    inorder = [9, 3, 15, 20, 7]
//    Return the following binary tree:

//     3
//    / \
//   9  20
//     /  \
//    15   7
  public class Solution
  {
    public TreeNode BuildTree(int[] preorder, int[] inorder)
    {
      return BuildTreeRecursive(preorder.ToList(), inorder.ToList());
    }

    public TreeNode BuildTreeRecursive(List<int> preorder, List<int> inorder)
    {
      if (!preorder.Any()) return null;

      var rootValue = preorder.First();

      var root = new TreeNode(rootValue);

      var rootIndex = inorder.IndexOf(rootValue);

      var inorderSubTrees = GetInorderSubtrees(inorder, rootIndex);

      var leftInorderSubTree = inorderSubTrees.leftInorderSubTree;

      var rightInorderSubTree = inorderSubTrees.rightInorderSubTree;

      var leftPreorderSubTree = preorder.GetRange(1, leftInorderSubTree.Count);

      var rightPreorderSubTree = preorder.GetRange(leftPreorderSubTree.Count + 1, rightInorderSubTree.Count);

      if (leftInorderSubTree.Count == 1) root.left = new TreeNode(leftInorderSubTree.First());

      if (leftInorderSubTree.Count > 1) root.left = BuildTreeRecursive(leftPreorderSubTree, leftInorderSubTree);

      if (rightInorderSubTree.Count == 1) root.right = new TreeNode(rightInorderSubTree.First());

      if (rightInorderSubTree.Count > 1) root.right = BuildTreeRecursive(rightPreorderSubTree, rightInorderSubTree);

      return root;
    }

    private (List<int> leftInorderSubTree, List<int> rightInorderSubTree) GetInorderSubtrees(List<int> inorder,
      int rootIndex)
    {
      var leftInorderSubTree = inorder.GetRange(0, rootIndex);

      var rightInorderSubTree = inorder.GetRange(rootIndex + 1, inorder.Count - rootIndex - 1);

      return (leftInorderSubTree, rightInorderSubTree);
    }
  }
}