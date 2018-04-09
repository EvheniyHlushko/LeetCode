using System;

namespace SymmetricTree_101
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      var node = new TreeNode(1);

      node.left = new TreeNode(2);

      node.left.left = new TreeNode(3);

      node.left.right = new TreeNode(4);

      node.right = new TreeNode(2);

      node.right.right = new TreeNode(3);

      node.right.left = new TreeNode(4);

      var solution = new Solution();

      var result = solution.IsSymmetricIteratively(node);

      Console.ReadKey();
    }
  }
}