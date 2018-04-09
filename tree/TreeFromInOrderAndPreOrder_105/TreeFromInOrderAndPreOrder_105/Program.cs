using System;

namespace TreeFromInOrderAndPreOrder_105
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      var inorder = new[] {9, 3, 15, 20, 7};

      var preorder = new[] {3, 9, 20, 15, 7};

      var solution = new Solution();

      var result = solution.BuildTree(preorder, inorder);

      Console.ReadKey();
    }
  }
}