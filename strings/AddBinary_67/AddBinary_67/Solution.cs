using System;
using System.Linq;
using System.Text;

namespace AddBinary_67
{
  //https://leetcode.com/problems/add-binary/description/
  //67. Add Binary

  // Given two binary strings, return their sum(also a binary string).
  //
  // The input strings are both non-empty and contains only characters 1 or 0.
  //
  // Example 1:
  //
  // Input: a = "11", b = "1"
  // Output: "100"
  // Example 2:
  //
  // Input: a = "1010", b = "1011"
  // Output: "10101"
  public class Solution
  {
    public string AddBinary(string a, string b)
    {
      string longest, shortest;
      if (a.Length > b.Length)
      {
        longest = a;
        shortest = b;

      }
      else
      {
        longest = b;
        shortest = a;
      }

      var diff = longest.Length - shortest.Length;

      var builder = new StringBuilder();

      var additional = '0';

      for (int i = longest.Length - 1; i > -1; i--)
      {
        var longValue = longest[i];
        var shortValue = i - diff >= 0 ? shortest[i - diff]: '0';
        
        switch (longValue)
        {
          case '1' when shortValue.Equals('1'):
            builder.Append(additional);
            additional = '1';
            break;
          case '0' when shortValue.Equals('0'):
            builder.Append(additional);
            additional = '0';
            break;
          default:
            builder.Append(additional.Equals('0') ? '1' : '0');
            break;
        }

        if (i == 0 && additional.Equals('1'))
        {
          builder.Append(additional);
        }

      }

      return Reverse(builder.ToString());
    }

    public static string Reverse(string s)
    {
      char[] charArray = s.ToCharArray();
      Array.Reverse(charArray);
      return new string(charArray);
    }
  }
}