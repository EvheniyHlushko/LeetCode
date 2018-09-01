using System.Linq;

namespace LongestCommonPrefix_14
{
  //  https://leetcode.com/problems/longest-common-prefix/description/
  //  14. Longest Common Prefix

  //    Write a function to find the longest common prefix string amongst an array of strings.
  //  
  //    If there is no common prefix, return an empty string "".
  //  
  //    Example 1:
  //  
  //    Input: ["flower","flow","flight"]
  //  Output: "fl"
  //  Example 2:
  //  
  //  Input: ["dog","racecar","car"]
  //  Output: ""
  //  Explanation: There is no common prefix among the input strings.
  //  Note:
  //  
  //  All given inputs are in lowercase letters a-z.
  public class Solution
  {
    public string LongestCommonPrefix(string[] strs)
    {
      if (!strs.Any())
      {
        return "";
      }

      if (strs.Length == 1)
      {
        return strs[0];
      }

      if (strs.All(x => x.Length == strs[0].Length && x == strs[0]))
      {
        return strs[0];
      }

      var length = strs.Min(x => x.Length);

      for (int i = 0; i < length; i++)
      {
        for (int j = 0; j < strs.Length - 1; j++)
        {
          if (strs[j][i] != strs[j+1][i])
          {
            return strs[j].Substring(0, i);
          }
        }

        if (i == length - 1)
        {
          return strs[0].Substring(0, length);
        }
      }

      return "";
    }
  }
}