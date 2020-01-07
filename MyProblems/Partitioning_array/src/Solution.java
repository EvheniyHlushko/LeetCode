public class Solution {
    public void sortByColors(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int i = 0;
        while(i <= right){
            if(arr[i] == 0){
                int temp = arr[left];
                arr[left] = 0;
                arr[i] = temp;
                left++;
                i++;
            }
            else if(arr[i] == 2){
                int temp = arr[right];
                arr[right] = 2;
                arr[i] = temp;
                right--;
            }
            else{
                i++;
            }
        }
    }
}
