using System;

namespace Largest_Number_At_Least_Twice_of_Others_747
{
    class Program
    {
        static void Main(string[] args)
        {
          var array = new[] { 3, 6, 1, 0 };

          var solution = new Solution();

          var result = solution.DominantIndex(array);

          Console.ReadKey();
        }
    }
}
