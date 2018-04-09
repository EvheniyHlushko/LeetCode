using System.Collections.Generic;

namespace BinaryTreeLevelOrderTraversal_102
{
//https://leetcode.com/problems/binary-tree-level-order-traversal/description/

//    102. Binary Tree Level Order Traversal

//    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

//    For example:
//    Given binary tree[3, 9, 20, null, null, 15, 7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
//    return its level order traversal as:
//    [
//    [3],
//    [9,20],
//    [15,7]
//    ]

  public class Solution
  {
    public IList<IList<int>> LevelOrder(TreeNode root)
    {
      var result = new List<IList<int>>();
      return LevelOrderSecond(root);
    }

    public List<IList<int>> LevelOrderSecond(TreeNode root)
    {
      var res = new List<IList<int>>();
      if (root == null) return res;

      var queue = new Queue<TreeNode>();
      queue.Enqueue(root);
      while (queue.Count > 0)
      {
        var level = new List<int>();
        var cnt = queue.Count;
        for (var i = 0; i < cnt; i++)
        {
          var node = queue.Dequeue();
          level.Add(node.val);
          if (node.left != null) queue.Enqueue(node.left);
          if (node.right != null) queue.Enqueue(node.right);
        }

        res.Add(level);
      }

      return res;
    }


    public List<IList<int>> LevelOrder(TreeNode root, List<IList<int>> result)
    {
      var queue = new Queue<TreeNode>();


      queue.Enqueue(root);
      var i = 1;

      var iter = i;
      var minus = 0;

      while (queue.Count > 0)
      {
        var res = new List<int>();
        var isNotNull = false;
        minus = minus * 2;
        for (var j = 0; j < iter; j++)
        {
          var item = queue.Dequeue();
          if (item != null)
          {
            res.Add(item.val);
            isNotNull = true;
            addChildrenToQueue(queue, item, ref minus);
          }
        }

        if (!isNotNull) break;

        result.Add(res);
        i = i * 2;

        iter = i - minus;
      }

      return result;
    }


    private void addChildrenToQueue(Queue<TreeNode> queue, TreeNode node, ref int minus)
    {
      if (node.left != null)
        queue.Enqueue(node.left);
      else
        minus++;

      if (node.right != null)
        queue.Enqueue(node.right);
      else
        minus++;
    }
  }
}