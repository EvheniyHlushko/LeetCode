using System.Collections.Generic;
using System.Linq;
using System.Text;
using SymmetricTree_101;

namespace SerializeAndDeserializeBinaryTree_297
{
//    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

//    297. Serialize and Deserialize Binary Tree

//    Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a        file o   r memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another         computer environment.

//    Design an algorithm to serialize and deserialize a binary tree.There is no restriction on how your serialization/            deserialization a   lgorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string      can be des erialized  to the original tree structure.

//    For example, you may serialize the following tree

//         1
//        / \
//       2   3
//          / \
//         4   5
//    as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
  public class Solution
  {
    // Encodes a tree to a single string.
    public string serialize(TreeNode root)
    {
      var result = new List<int?>();

      var levelOrder = LevelOrderSecond(root);

      var res = HandleLevelOrder(levelOrder);

      return res;
    }

    private string HandleLevelOrder(List<IList<int?>> levels)
    {
      var lists = new List<int?>();
      foreach (var level in levels) lists = lists.Concat(level).ToList();

      var builder = new StringBuilder();

      for (var i = 0; i < lists.Count; i++)
      {
        builder.Append(lists[i] == null ? "null" : lists[i].ToString());
        if (i == lists.Count - 1) continue;

        builder.Append(',');
      }

      return builder.ToString();
    }

    public List<IList<int?>> LevelOrderSecond(TreeNode root)
    {
      var res = new List<IList<int?>>();
      if (root == null) return res;

      var queue = new Queue<TreeNode>();
      queue.Enqueue(root);
      while (queue.Count > 0)
      {
        var level = new List<int?>();
        var cnt = queue.Count;
        for (var i = 0; i < cnt; i++)
        {
          var node = queue.Dequeue();
          level.Add(node?.val);
          queue.Enqueue(node?.left);
          queue.Enqueue(node?.right);
        }

        if (level.All(x => x == null)) break;

        res.Add(level);
      }

      return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data)
    {
      var result = data.Split(',');

      var res = new List<int?>();
      foreach (var s in result) res.Add(int.TryParse(s, out var x) ? (int?) x : null);

      var queue = new Queue<int?>(res);

      var lists = GetLists(queue);

      var treeNodeLists = GetTreeNodeLists(lists);

      foreach (var list in treeNodeLists)
      {
        var index = treeNodeLists.IndexOf(list);
        if (index + 1 != treeNodeLists.Count)
          GetNodesFromArrays(list.ToList(), new Queue<TreeNode>(treeNodeLists[index + 1]));
      }

      return treeNodeLists[0][0];
    }

    private List<IList<TreeNode>> GetTreeNodeLists(List<IList<int?>> lists)
    {
      var result = new List<IList<TreeNode>>();

      foreach (var list in lists)
      {
        var nodeList = new List<TreeNode>();
        foreach (var i in list) nodeList.Add(i != null ? new TreeNode((int) i) : null);
        result.Add(nodeList);
      }

      return result;
    }

    private List<IList<int?>> GetLists(Queue<int?> queue)
    {
      var result = new List<IList<int?>>();
      var count = 1;
      while (queue.Count > 0)
      {
        result.Add(DequeueChunk(queue, count).ToList());
        count = count * 2;
      }

      return result;
    }


    public void Recursive(TreeNode root, List<int?> result)
    {
      if (root == null) return;

      result.Add(root?.left?.val);

      result.Add(root?.right?.val);

      Recursive(root?.left, result);

      Recursive(root?.right, result);
    }

    public List<TreeNode> GetNodesFromArrays(List<TreeNode> first, Queue<TreeNode> second)
    {
      var result = new List<TreeNode>();
      foreach (var node in first)
      {
        if (node == null)
        {
          result = DequeueChunk(second, 2).ToList();
          continue;
        }

        var left = second.Dequeue();
        node.left = left;
        var right = second.Dequeue();
        node.right = right;
        result.Add(node);
      }

      return result;
    }

    public static IEnumerable<T> DequeueChunk<T>(Queue<T> queue, int chunkSize)
    {
      for (var i = 0; i < chunkSize && queue.Count > 0; i++) yield return queue.Dequeue();
    }
  }
}