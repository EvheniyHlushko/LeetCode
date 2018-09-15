using System;
using System.Collections.Generic;
using System.Linq;

namespace LongestConsecutiveSequence_128
{
  //https://leetcode.com/problems/longest-consecutive-sequence/description/
  //128. Longest Consecutive Sequence

//    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//  Your algorithm should run in O(n) complexity.
//
//  Example:
//
//  Input: [100, 4, 200, 1, 3, 2]
//  Output: 4
//  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
  public class Solution
  {
    public int LongestConsecutive(int[] nums)
    {
      if (nums.Length == 0)
      {
        return 0;
      }

      if (nums.Length == 1)
      {
        return 1;
      }

      Array.Sort(nums);

      var result = 1;

      var max = 1;

      for (int i = 1; i < nums.Length; i++)
      {

        if (nums[i] == nums[i - 1])
        {
          continue;
        }

        if (nums[i] - 1 == nums[i - 1])
        {
          max++;
          continue;
        }

        result = max > result ? max : result;

        max = 1;
      }

      result = max > result ? max : result;

      return result;
    }
  }
}