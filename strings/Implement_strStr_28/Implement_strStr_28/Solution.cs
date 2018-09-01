using System.Collections.Generic;
using System.Linq;

namespace Implement_strStr_28
{
  //  https://leetcode.com/problems/implement-strstr/description/
  //  28. Implement strStr()
  //  mplement strStr().
  //  
  //  eturn the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
  //  
  //  xample 1:
  //  
  //  nput: haystack = "hello", needle = "ll"
  //  utput: 2
  //  xample 2:
  //  
  //  nput: haystack = "aaaaa", needle = "bba"
  //  utput: -1
  //  larification:
  //  
  //  hat should we return when needle is an empty string? This is a great question to ask during an interview.
  //  
  //  or the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's //indexOf().
  public class Solution
  {
    public int StrStr(string haystack, string needle)
    {
      if (string.IsNullOrEmpty(needle))
      {
        return 0;
      }

      if (string.IsNullOrEmpty(haystack) || needle.Length > haystack.Length)
      {
        return -1;
      }

      if (needle.Length == haystack.Length)
      {
        return needle.Equals(haystack) ? 0 : -1;
      }

      var indexes = new List<int>();

      for (int i = 0; i < haystack.Length; i++)
      {
        SeCheckedIndex(haystack, needle, i, indexes);

        if (indexes.Any(x => x == needle.Length))
        {
          return i - needle.Length + 1;
        }
      }

      return -1;
    }

    private static void SeCheckedIndex(string haystack, string needle, int i, List<int> indexes)
    {
      for (var j = 0; j < indexes.Count; j++)
      {
        var index = indexes[j];
        if (haystack[i].Equals(needle[(int)index]))
        {
          index++;
        }
        else
        {
          index = 0;
        }

        indexes[j] = index;
      }

      indexes.RemoveAll(x => x == 0);

      if (haystack[i].Equals(needle[0]))
      {
        indexes.Add(1);
      }
    }
  }
}