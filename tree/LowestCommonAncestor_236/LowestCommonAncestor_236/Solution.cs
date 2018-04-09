using System.Collections.Generic;

namespace LowestCommonAncestor_236
{
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

//236. Lowest Common Ancestor of a Binary Tree

//    Given a binary tree, find the lowest common ancestor(LCA) of two given nodes in the tree.

//    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as      the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

//         _______3______
//         /              \
//     ___5__           ___1__
//    /      \        /       \
//   6      _2       0         8
//         /  \
//         7   4
//    For example, the lowest common ancestor(LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a     node can be a descendant of itself according to the LCA definition.


  public class Solution
  {
    //public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    //{
    //  if (root == null || root.Equals(p) || root.Equals(q))
    //  {
    //    return root;
    //  }

    //  var left = LowestCommonAncestor(root.left, p, q);
    //  var right = LowestCommonAncestor(root.right, p, q);

    //  return left != null && right != null ? root : (left ?? right);
    //}


    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
      if (p == null || q == null) return null;

      if (p == root || q == root) return root;

      var n1 = GetPath(root, p);
      var n2 = GetPath(root, q);

      TreeNode prev = null;

      while (n1.Count > 0 && n2.Count > 0)
      {
        var n1Node = n1.Pop();

        var n2Node = n2.Pop();

        if (n1Node == n2Node)
          prev = n1Node;
        else
          break;
      }

      return prev;
    }

    private Stack<TreeNode> GetPath(TreeNode root, TreeNode n1)
    {
      Stack<TreeNode> result = null;

      if (root == null) return null;

      if (root == n1)
      {
        result = new Stack<TreeNode>();
        result.Push(root);
      }

      var leftResult = GetPath(root.left, n1);

      var rightResult = GetPath(root.right, n1);


      if (leftResult != null && rightResult != null)
      {
        result = new Stack<TreeNode>();
        result.Push(root);
        return result;
      }

      if (rightResult != null)
      {
        result = rightResult;
        result.Push(root);
        return result;
      }

      if (leftResult != null)
      {
        result = leftResult;
        result.Push(root);
        return result;
      }


      return result;
    }
  }
}