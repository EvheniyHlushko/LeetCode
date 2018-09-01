using System;

namespace SpiralMatrix_54
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      var matrix = new[,] {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};

      var solution = new Solution();

      var result = solution.SpiralOrder(matrix);

      Console.ReadKey();
    }
  }
}