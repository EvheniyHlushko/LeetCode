using System;

namespace BinaryTreeInorderTraversal_94
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      var node = new TreeNode(4);

      node.left = new TreeNode(2);

      node.left.left = new TreeNode(1);

      node.left.right = new TreeNode(3);

      node.right = new TreeNode(5);

      node.right.right = new TreeNode(7);

      node.right.right.left = new TreeNode(6);

      node.right.right.right = new TreeNode(8);

      var solution = new Solution();

      var result = solution.InorderTraversal(node);

      Console.ReadKey();
    }
  }
}