using System;

namespace TreeFromInOrderAndPostOrder_106
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      //var inOrder = new[] { 9, 3, 15, 20, 7 };

      //var postOrder = new [] { 9, 15, 7, 20, 3 };

      var inOrder = new[] {3,2,1};

      var postOrder = new[] { 3, 2, 1 };

      var solution = new Solution();

      var result = solution.BuildTree(inOrder, postOrder);

      Console.ReadKey();
    }
  }
}