using System.Collections.Generic;

namespace BinaryTreeInorderTraversal_94
{
  // https://leetcode.com/problems/binary-tree-inorder-traversal/description/

  //    94. Binary Tree Inorder Traversal

  //    Given a binary tree, return the inorder traversal of its nodes' values.

  //    For example:
  //    Given binary tree[1, null, 2, 3],
  //   1
  //    \
  //     2
  //    /
  //   3
  //    return [1,3,2].


  public class Solution
  {
    //public IList<int> PreorderTraversal(TreeNode root)
    //{
    //  //var result = new List<int>();

    //  //result = Recursive(root, result);

    //  var result = Recursive(root).ToList();

    //  return result;
    //}


    public List<int> InOrder(TreeNode root)
    {
      var result = new List<int>();
      var stack = new Stack<TreeNode>();

      var node = root;

      while (node != null)
      {
        if (node.left != null)
        {
          stack.Push(node);
          node = node.left;
          continue;
        }


        result.Add(node.val);


        while (stack.Count > 0)
        {
          node = stack.Pop();

          result.Add(node.val);

          if (node.right != null && stack.Count == 0)
          {
            node = node.right;
            result.Add(node.val);
            break;
          }

          if (node.right != null)
          {
            node = node.right;
            break;
          }
        }

        if (stack.Count == 0)
          node = node.right;
      }

      return result;
    }

    public IList<int> InorderTraversal(TreeNode root)
    {
      var res = new List<int>();
      var curr = root;
      TreeNode pre;
      while (curr != null)
        if (curr.left == null)
        {
          res.Add(curr.val);
          curr = curr.right; // move to next right node
        }
        else
        {
          // has a left subtree
          pre = curr.left;
          while (pre.right != null)

            // find rightmost
            pre = pre.right;
          pre.right = curr; // put cur after the pre node
          var temp = curr; // store cur node
          curr = curr.left; // move cur to the top of the new tree
          temp.left = null; // original cur left be null, avoid infinite loops
        }

      return res;
    }


    public List<int> MorrisTraversal(TreeNode root)
    {
      var result = new List<int>();

      var current = root;

      TreeNode pre;

      while (current != null) //current = 4 // 2 // 1
        if (current.left == null) //false // false
        {
          result.Add(current.val);
          current = current.right;
        }
        else
        {
          pre = current.left; // current.left = 2 // 1

          while (pre.right != null) //find right most = 3
            pre = pre.right;

          pre.right = current; // pre right = null but set current = 4 // pre right set 1 
          var temp = current; // temp set current too = 4 
          current = current.left; //current set = 2
          temp.left = null; // delete 2 from current 
        }

      return result;
    }


    public List<int> inorderTraversal(TreeNode root)
    {
      var res = new List<int>();
      var stack = new Stack<TreeNode>();
      var curr = root;
      while (curr != null || stack.Count > 0) //4
      {
        while (curr != null)
        {
          stack.Push(curr); //4 to stack //2 to stack //1 to stack 
          curr = curr.left; //2 //1 //null
        }

        curr = stack.Pop(); // 1 //2 
        res.Add(curr.val); // 1
        curr = curr.right; // null //3
      }

      return res;
    }

    public void helperRecursive(TreeNode root, List<int> res)
    {
      if (root != null)
      {
        if (root.left != null) helperRecursive(root.left, res);
        res.Add(root.val);
        if (root.right != null) helperRecursive(root.right, res);
      }
    }

    public List<int> RecursiveSolution(TreeNode root)
    {
      var result = new List<int>();
      helperRecursive(root, result);
      return result;
    }
  }
}