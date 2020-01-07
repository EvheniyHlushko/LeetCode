public class Solution {

    public void rearrangeElements(int[] arr, int pivot){
        int start = 0;
        int end = arr.length - 1;

        int i = 0;

        while (i <= end){
            if(arr[i] > pivot){
                int temp = arr[i];
                arr[i] = arr[end];
                arr[end] = temp;
                end--;
                continue;
            }
            if(arr[i] < pivot){
                int temp = arr[start];
                arr[i] = arr[start];
                arr[start] = temp;
                start++;
                i++;
                continue;
            }

            i++;

        }
    }
}
