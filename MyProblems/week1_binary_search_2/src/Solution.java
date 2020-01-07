public class Solution {
/*    public int getIndex(int[] arr, int k){
        if (arr == null) {
            return -1;
        }
        int closest = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            int mid = start + (end - start)/2;
            closest = setClosest(mid, closest, k, arr);
            if(arr[mid] < k){
                start = mid + 1;
            }
            else if(arr[mid] > k){
                end = mid - 1;
            }
            else {
                return mid;
            }
        }

        return closest;
    }

    public int setClosest(int mid, int closest, int k, int[] arr){
        if(closest == -1 || arr[mid] - k > 0 && (arr[mid] - k < closest))
            return mid;
        return closest;
    }*/

    public int getIndex(int[] arr, int k){
        if (arr == null) {
            return -1;
        }
        int closest = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] < k){
                start = mid + 1;
            }
            else if(arr[mid] > k){
                end = mid;
            }
            else {
                return mid;
            }
        }

        return start;
    }
}
