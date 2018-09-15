using System;

namespace LongestConsecutiveSequence_128
{
  internal class Program
  {
    private static void Main(string[] args)
    {
      var solution = new Solution();
      var nums = new[] {1, 2, 0, 1};
      var result = solution.LongestConsecutive(nums);

      Console.ReadKey();
    }
  }
}