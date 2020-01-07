public class Solution {
    public static int waysToClimb(int n) {
        int[] a = new int[n + 1];
        a[0] = 1;
        for (int i = 0; i < a.length; i++) {
            if (i + 1 < a.length) a[i + 1] += a[i];
            if (i + 3 < a.length) a[i + 3] += a[i];
            if (i + 5 < a.length) a[i + 5] += a[i];
        }
        return a[n];
    }

}
