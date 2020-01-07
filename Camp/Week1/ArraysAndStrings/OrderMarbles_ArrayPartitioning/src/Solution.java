public class Solution {
    public void orderMarbles(int[] arr){
        int lowBoundary = getLowBoundary(arr);
        int highBoundary = getHighBoundary(arr);
        int i = lowBoundary;

        while(i <= highBoundary){
            if(arr[i] == 0){
                swap(arr, i, lowBoundary);
                lowBoundary++;
            }
            else if(arr[i] == 2){
                swap(arr, i, highBoundary);
                highBoundary --;
            }

            i++;
        }
    }

    public void swap(int[] arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    private int getLowBoundary(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                return i < arr.length + 1 ? i + 1 : i;
            }
            else{
                return i;
            }
        }

        return arr.length - 1;
    }

    private int getHighBoundary(int[] arr){
        for (int i = arr.length - 1; i >= 0 ; i++) {
            if(arr[i] == 2){
                return i - 1 >= 0 ? i - 1 : i;
            }
            else{
                return i;
            }
        }

        return 0;
    }

}
