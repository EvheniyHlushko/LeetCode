using System.Collections.Generic;

namespace BinaryTreePreorderTraversal_144
{
  //144. Binary Tree Preorder Traversal

  //Given a binary tree, return the preorder traversal of its nodes' values.

  //    For example:
  //    Given binary tree[1, null, 2, 3],
  //         1
  //          \
  //            2
  //          /
  //         3
  //    return [1,2,3].
  public class Solution
  {
    //public IList<int> PreorderTraversal(TreeNode root)
    //{
    //  //var result = new List<int>();

    //  //result = Recursive(root, result);

    //  //var result = preorderTraversal(root).ToList();

    // // return result;
    //}


    public List<int> Recursive(TreeNode root, List<int> result)
    {
      result.Add(root.val);

      if (root.left != null)
      {
        result = Recursive(root.left, result);
      }

      if (root.right != null)
      {
        return Recursive(root.right, result);
      }

      return result;

    }


    public static IEnumerable<int> Preorder(TreeNode root)
    {
      var stack = new Stack<TreeNode>();
      stack.Push(root);
      var current = root;
      while (stack.Count > 0 || current != null)
      {
        var node = stack.Pop();
        yield return node.val;
        if (node.right != null)
          stack.Push(node.right);
        if (node.left != null)
          stack.Push(node.left);
      }
    }

    public List<int> preorderTraversal(TreeNode root)
    {
      List<int> list = new List<int>();
      if (root == null) return list;
      Stack<TreeNode> stack = new Stack<TreeNode>();
      stack.Push(root);
      while (stack.Count > 0)
      {
        TreeNode current = stack.Pop();
        list.Add(current.val);
        if (current.right != null) stack.Push(current.right);
        if (current.left != null) stack.Push(current.left);
      }
      return list;
    }
  }
}