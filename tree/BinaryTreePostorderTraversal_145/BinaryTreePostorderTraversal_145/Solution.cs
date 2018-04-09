using System.Collections.Generic;

namespace BinaryTreePostorderTraversal_145
{
//https://leetcode.com/problems/binary-tree-postorder-traversal/description/

//145. Binary Tree Postorder Traversal

//    Given a binary tree, return the postorder traversal of its nodes' values.

//    For example:
//    Given binary tree[1, null, 2, 3],

//   1
//    \
//     2
//    /
//   3


//return [3,2,1].

  public class Solution
  {
    public IEnumerable<int> Recursive(TreeNode root)
    {
      var result = new List<int>();
      RecursiveSolution(root, result);
      return result;
    }

    private void RecursiveSolution(TreeNode root, List<int> result)
    {
      if (root == null) return;

      if (root.left != null) RecursiveSolution(root.left, result);

      if (root.right != null) RecursiveSolution(root.right, result);

      result.Add(root.val);
    }

    public List<int> Iteratively(TreeNode root)
    {
      var res = new List<int>();
      var stack = new Stack<TreeNode>();
      var curr = root;
      while (curr != null || stack.Count > 0)
      {
        while (curr != null)
        {
          var pre = curr;
          curr = curr.left;
          pre.left = null;
          stack.Push(pre);
        }

        curr = stack.Pop(); // 1 //2
        if (curr.right != null)
        {
          var pre = curr;
          curr = curr.right;
          pre.right = null;
          stack.Push(pre);
          continue;
        }

        res.Add(curr.val);
        if (stack.Count == 0) break;

        curr = stack.Pop();
        curr.left = null;
        if (curr.right != null)
        {
          var pre = curr;
          curr = curr.right;
          pre.right = null;

          stack.Push(pre);
          continue;
        }

        res.Add(curr.val);

        curr = stack.Count > 0 ? stack.Pop() : null;
      }

      return res;
    }

    public List<int> postorderTraversal(TreeNode root)
    {
      var s = new Stack<TreeNode>();
      var ans = new List<int>();
      var cur = root;

      while (cur != null || s.Count > 0)
      {
        while (!isLeaf(cur))
        {
          s.Push(cur);
          cur = cur.left;
        }

        if (cur != null) ans.Add(cur.val);

        while (s.Count > 0 && cur == s.Peek().right)
        {
          cur = s.Pop();
          ans.Add(cur.val);
        }

        if (s.Count == 0) cur = null;
        else cur = s.Peek().right;
      }

      return ans;
    }

    private bool isLeaf(TreeNode r)
    {
      if (r == null) return true;

      return r.left == null && r.right == null;
    }
  }
}