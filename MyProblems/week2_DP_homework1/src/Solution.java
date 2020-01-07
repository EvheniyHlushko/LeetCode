public class Solution {
    public int getLongestSubsequence(int[] arr){
        int max = 0;

        int[] results = new int[arr.length];

        results[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            results[i] = arr[i] > arr[i -1] ? results[i - 1] + 1 : 1;
            max = Math.max(max, results[i]);
        }

        return max;
    }
}
