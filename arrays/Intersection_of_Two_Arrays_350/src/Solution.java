import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] Intersect(int[] nums1, int[] nums2) {
        quickSort(nums1, 0, nums1.length - 1);
        quickSort(nums2, 0, nums2.length - 1);

        int[] longer;
        int[] shortest;

        if(nums1.length > nums2.length){
            longer = nums1;
            shortest = nums2;
        }
        else{
            longer = nums2;
            shortest = nums1;
        }

        return calculate(longer, shortest);
    }

    private int[] calculate(int[] longer, int[] shortest) {
        List<Integer> result = new ArrayList<Integer>();
        int i = 0;

        int j = 0;
        while(i < longer.length && j < shortest.length){


            if(longer[i] == shortest[j]){
                result.add(longer[i]);
                i++;
                j++;
                continue;
            }

            if(longer[i] > shortest[j]){
                j++;
                continue;
            }

            i++;
        }
        return convertListToArray(result);
    }

    private int[] convertListToArray(List<Integer> listResult){
        int size = listResult.size();
        int[] result = new int[size];
        Integer[] temp = listResult.toArray(new Integer[size]);
        for (int n = 0; n < size; ++n) {
            result[n] = temp[n];
        }

        return result;
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
}

