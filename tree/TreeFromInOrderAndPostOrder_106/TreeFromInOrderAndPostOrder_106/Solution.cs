using System.Collections.Generic;
using System.Linq;

namespace TreeFromInOrderAndPostOrder_106
{

//    https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

//    106. Construct Binary Tree from Inorder and Postorder Traversal

//    Given inorder and postorder traversal of a tree, construct the binary tree.

//    Note:
//    You may assume that duplicates do not exist in the tree.

//    For example, given

//    inorder = [9, 3, 15, 20, 7]
//    postorder = [9, 15, 7, 20, 3]
//    Return the following binary tree:

//     3
//    / \
//   9  20
//     /  \
//    15   7

  public class Solution
  {
    public TreeNode BuildTree(int[] inorder, int[] postorder)
    {
      return Recursive(inorder.ToList(), postorder.ToList());
    }


    public TreeNode Recursive(List<int> inorder, List<int> postorder)
    {
      if (inorder.Count == 0)
      {
        return null;
      }


      var rootValue = postorder.Last();

      var root = new TreeNode(rootValue);

      if (inorder.Count == 1)
      {
        return root;
      }

      var rootIndex = inorder.IndexOf(rootValue);

      var leftSubtrees = GetLeftSubTrees(rootIndex, inorder, postorder);

      var leftPostOrderSubTree = leftSubtrees.postorder;

      var leftInOrderSubTree = leftSubtrees.inorder;

      var rightInOrderSubTree = inorder.GetRange(rootIndex + 1, inorder.Count - rootIndex - 1);


      var rightPostOrderSubTree = postorder.GetRange(leftPostOrderSubTree.Count, rightInOrderSubTree.Count);

      if (rightPostOrderSubTree.Count == 1)
      {
        root.right = new TreeNode(rightPostOrderSubTree.First());
      }

      if (rightPostOrderSubTree.Count > 1)
      {
        root.right = BuildTree(rightInOrderSubTree.ToArray(), rightPostOrderSubTree.ToArray());
      }

      if (leftPostOrderSubTree.Count == 1)
      {
        root.left = new TreeNode(leftPostOrderSubTree.First());
      }

      if (leftPostOrderSubTree.Count > 1)
      {
        root.left = BuildTree(leftInOrderSubTree.ToArray(), leftPostOrderSubTree.ToArray());
      }

      return root;
    }


    public (List<int> inorder, List<int> postorder) GetLeftSubTrees (int rootIndex, List<int> inorder, List<int> postorder) {
      var leftInOrderSubTree = inorder.GetRange(0, rootIndex);

      var leftPostOrderSubTree = postorder.GetRange(0, leftInOrderSubTree.Count);

      return (leftInOrderSubTree, leftPostOrderSubTree);
    }
  }
}