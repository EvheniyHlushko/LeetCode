public class Solution {
    public int[] getShortestSortedSubArray(int[] array){
        int i,j = 0;

        for (i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i + 1]){
                break;
            }
        }

        for (j = array.length - 1; j > 0; j--) {
            if(array[j] < array[j - 1]){
                break;
            }
        }

        if(j <= 0 || i >= array.length - 1){
            return new int[]{};
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int start = i; start < j; start++) {
            if(array[start] > max){
                max = array[start];
            }
            if(array[start] < min){
                min = array[start];
            }

        }

        for (int k = i - 1; k >= 0; k--) {
            if(array[k] < array[i]){
                i = k;
                break;
            }
        }

        for (int k = j; k < array.length - 1; k++) {
            if(array[k] < array[j]){
                j = k;
            }
        }

        return new int[]{i,j};
    }
}
