namespace Largest_Number_At_Least_Twice_of_Others_747
{
  //https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
  //    747. Largest Number At Least Twice of Others
  //    In a given integer array nums, there is always exactly one largest element.

  //    Find whether the largest element in the array is at least twice as much as every other number in the array.

  //    If it is, return the index of the largest element, otherwise return -1.

  //    Example 1:

  //    Input: nums = [3, 6, 1, 0]
  //    Output: 1
  //    Explanation: 6 is the largest integer, and for every other number in the array x,
  //    6 is more than twice as big as x.The index of value 6 is 1, so we return 1.

  //    Example 2:

  //    Input: nums = [1, 2, 3, 4]
  //    Output: -1
  //    Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.

  //    Note:
  //    nums will have a length in the range [1, 50].
  //    Every nums[i] will be an integer in the range [0, 99].

  public class Solution
  {
    public int DominantIndex(int[] nums)
    {
      return DominantIndexInternal(nums);
    }

    private int DominantIndexInternal(int[] nums)
    {
      var maxElementIndex = GetMaxElementIndex(nums);

      for (var i = 0; i < nums.Length; i++)
        if (maxElementIndex != i && nums[maxElementIndex] < nums[i] * 2)
          return -1;

      return maxElementIndex;
    }

    private int GetMaxElementIndex(int[] nums)
    {
      var maxElementIndex = 0;
      for (var i = 1; i < nums.Length; i++)
        if (nums[maxElementIndex] < nums[i])
          maxElementIndex = i;

      return maxElementIndex;
    }
  }
}