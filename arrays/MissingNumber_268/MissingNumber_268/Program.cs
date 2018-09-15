using System;

namespace MissingNumber_268
{
    class Program
    {
        static void Main(string[] args)
        {
          var solution = new Solution();

          var nums = new int[]{ 9, 6, 4, 2, 3, 5, 7, 0, 1 };

          var result = solution.MissingNumber(nums);

          Console.ReadKey();
        }
    }
}
