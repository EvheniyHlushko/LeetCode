using System.Collections.Generic;
using System.Linq;

namespace SpiralMatrix_54
{
  //  https://leetcode.com/problems/spiral-matrix/description/
  //  54. Spiral Matrix
  //    Given a matrix of m x n elements(m rows, n columns), return all elements of the matrix in spiral order.
  
  //    Example 1:
  
  //    Input:
  //  [
  //  [ 1, 2, 3 ],
  //  [ 4, 5, 6 ],
  //  [ 7, 8, 9 ]
  //  ]
  //  Output: [1,2,3,6,9,8,7,4,5]
  //  Example 2:
  
  //  Input:
  //  [
  //  [1, 2, 3, 4],
  //  [5, 6, 7, 8],
  //  [9,10,11,12]
  //  ]
  //  Output: [1,2,3,4,8,12,11,10,9,5,6,7]
  public class Solution
  {
    public IList<int> SpiralOrder(int[,] matrix)
    {
      return SpiralOrderInternal(matrix);
    }

    private IList<int> SpiralOrderInternal(int[,] matrix)
    {
      var result = new List<int>();

      if (matrix.Length == 0)
      {
        return result;
      }

      var rows = matrix.GetUpperBound(0) + 1;
      var columns = matrix.Length / rows;

      TraverseRow(result, matrix, true, columns, 0);

      for (int j = 1; j < rows; j++)
      {
        result.Add(matrix[j, columns - 1]);
      }

      var isDirect = false;

      for (int i = rows - 1; i > 0; i--)
      {
        TraverseRow(result, matrix, isDirect, columns - 1, i);
        isDirect = !isDirect;
      }

      return result;

    }

    private void TraverseRow(List<int> result, int[,] matrix, bool direct, int colums, int rowNumber)
    {
      var res = new List<int>();
    

      for (int i = 0; i < colums; i++)
      {
        res.Add(matrix[rowNumber, i]);
      }

      if (!direct)
      {
        res.Reverse();
      }

      result.AddRange(res);
    }
  }
}