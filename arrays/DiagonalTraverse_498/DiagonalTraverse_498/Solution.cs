using System.Collections.Generic;

namespace DiagonalTraverse_498
{
  //https://leetcode.com/problems/diagonal-traverse/description/
  //498. Diagonal Traverse
  //  Given a matrix of M x N elements(M rows, N columns), return all elements of the matrix in diagonal order as shown in the   below image.

  //  Example:
  //  Input:
  //  [
  //  [ 1, 2, 3 ],
  //  [ 4, 5, 6 ],
  //  [ 7, 8, 9 ]
  //  ]
  //  Output:  [1,2,4,7,5,3,6,8,9]
  //  Explanation:

  //  Note:
  //  The total number of elements of the given matrix will not exceed 10,000.
  public class Solution
  {
    public int[] FindDiagonalOrder(int[,] matrix)
    {
      return FindDiagonalOrderInternal(matrix);
    }

    private int[] FindDiagonalOrderInternal(int[,] matrix)
    {
      var result = new List<int>();

      if (matrix.Length == 0)
      {
        return result.ToArray();
      }

      var rows = matrix.GetUpperBound(0) + 1;
      var columns = matrix.Length / rows;

      var reverse = false;
      for (var i = 0; i < rows; i++)
      {
        var res = new List<int>();
        if (i > 0)
        {
          reverse = SetResultForColumn(matrix, reverse, res, columns, rows, i, columns - 1, result);

          continue;
        }

        for (var j = 0; j < columns; j++)
        {
          reverse = SetResultForColumn(matrix, reverse, res, columns, rows, i, j, result);
        }
      }

      return result.ToArray();
    }

    private bool SetResultForColumn(int[,] matrix, bool reverse, List<int> res, int columns, int rows, int i, int j,
      List<int> result)
    {
      reverse = !reverse;
      res.Clear();
      AddElementRecursively(columns, rows, matrix, res, (i, j), reverse);
      if (reverse)
      {
        res.Reverse();
      }

      result.AddRange(res);
      return reverse;
    }

    public void AddElementRecursively(int colums, int rows, int[,] matrix, ICollection<int> result,
      (int i, int j) elementIndex, bool reverse)
    {
      result.Add(matrix[elementIndex.i, elementIndex.j]);

      if (elementIndex.j > 0 && rows > elementIndex.i + 1)
      {
        AddElementRecursively(colums, rows, matrix, result, (elementIndex.i + 1, elementIndex.j - 1), reverse);
      }
    }
  }
}