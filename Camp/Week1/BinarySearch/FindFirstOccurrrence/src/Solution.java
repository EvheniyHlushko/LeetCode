public class Solution {
    public int findFirstOccurrence(int[] array, int element) {
        int start = 0;
        int end = array.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] < element) {
                start = mid + 1;
            } else if (array[mid] > element || (mid > 0 && array[mid - 1] == element)) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;

    }
}
