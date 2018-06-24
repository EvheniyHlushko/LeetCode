using System;

namespace DiagonalTraverse_498
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      var mas = new[,] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

      //var rows = mas.GetUpperBound(0) + 1;
      //var columns = mas.Length / rows;

      //for (var i = 0; i < rows; i++)
      //{
      //  for (var j = 0; j < columns; j++)
      //  {
      //    Console.Write($"{mas[i, j]} \t");
      //  }

      //  Console.WriteLine();
      //}

      var solution = new Solution();

      var result = solution.FindDiagonalOrder(mas);

      Console.ReadKey();
    }
  }
}