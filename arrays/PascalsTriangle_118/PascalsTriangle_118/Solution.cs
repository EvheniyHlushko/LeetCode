using System.Collections.Generic;
using System.Runtime.Serialization.Formatters;

namespace PascalsTriangle_118
{
  //  https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1170/
  //  118. Pascal's Triangle
  //  Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
  //  In Pascal's triangle, each number is the sum of the two numbers directly above it.

  //    Input: 5
  //    Output:
  //      [
  //       [1],
  //      [1,1],
  //     [1,2,1],
  //    [1,3,3,1],
  //   [1,4,6,4,1]
  //      ]
  public class Solution
  {
    public IList<IList<int>> Generate(int numRows)
    {
      return CreateArrays(numRows);

    }


    private IList<IList<int>> CreateArrays(int numRows)
    {
      var result = new IList<int>[numRows];
      for (var i = 0; i < numRows; i++)
      {
        result[i] = new int[i+1];

        result[i][0] = 1;
        result[i][i] = 1;

        if (i <= 0 || result[i - 1].Count <= 1)
        {
          continue;
        }

        var previousArray = result[i - 1];

        for (var j = 1; j < result[i].Count - 1; j++)
        {
          result[i][j] = previousArray[j - 1] + previousArray[j];
        }
      }

      return result;
    }
  }
}