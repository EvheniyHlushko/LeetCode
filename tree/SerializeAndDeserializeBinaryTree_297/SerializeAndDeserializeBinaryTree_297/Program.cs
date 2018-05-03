using System;
using SymmetricTree_101;

namespace SerializeAndDeserializeBinaryTree_297
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      //var root = new TreeNode(1);
      //root.left = new TreeNode(2);
      //root.right = new TreeNode(3);
      //root.right.left = new TreeNode(4);
      //root.right.right = new TreeNode(5);

      var root = new TreeNode(5);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.right.left = new TreeNode(2);
      root.right.right = new TreeNode(4);

      root.right.left.left = new TreeNode(3);

      root.right.left.right = new TreeNode(1);


      var solution = new SecondSolution();

      var result = solution.serialize(root);


      // var deserializeResult = solution.deserialize("1,2,3,null,null,4,5");

      var deserializeResult = solution.deserialize(result);

      Console.ReadKey();
    }
  }
}