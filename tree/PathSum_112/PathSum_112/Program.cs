using System;

namespace PathSum_112
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      var node = new TreeNode(5);

      node.left = new TreeNode(4);

      node.right = new TreeNode(8);

      node.left.left = new TreeNode(11);

      node.left.left.left = new TreeNode(7);

      node.left.left.right = new TreeNode(2);

      node.right.left = new TreeNode(13);
      node.right.right = new TreeNode(4);

      node.right.right.right = new TreeNode(1);


      node = new TreeNode(1);

      var solution = new Solution();

      var result = solution.HasPathSum(node, 1);

      Console.ReadKey();
    }
  }
}