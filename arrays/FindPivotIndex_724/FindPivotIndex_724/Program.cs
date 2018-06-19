using System;

namespace FindPivotIndex_724
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      var array = new[] {-1, -1, -1, -1, -1, -1};

      var solution = new Solution();

      var result = solution.PivotIndex(array);

      Console.ReadKey();
    }
  }
}