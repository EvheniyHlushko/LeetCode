using System;

namespace AddBinary_67
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      string a = "1010", b = "1011";

      var solution = new Solution();

      var result = solution.AddBinary(a, b);

      Console.ReadKey();
    }
  }
}