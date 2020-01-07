public class Solution {
    public int getIndexForTargetElement(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low)/2;

            if(arr[mid] < target){
                if(mid == arr.length - 1){
                    return arr.length;
                }
                low = mid + 1;
            }
            else{
                if(mid == 0 || arr[mid - 1] <= target){
                    return mid;
                }
                high = mid - 1;
            }
        }

        return -1;

    }
}
