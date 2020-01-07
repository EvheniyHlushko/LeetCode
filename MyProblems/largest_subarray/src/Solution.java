public class Solution {
    public int[] getSubArrayWithLargestSum(int[] arr){
        int start = 0;
        int end = 0;

        int i = 0;
        int sum = 0;

        while(i < arr.length){
            int tempStart = i;
            int tempEnd = i;
            int tempSum = 0;
            int biggestSum = 0;
            while(i < arr.length && tempSum + arr[i] > 0){
                tempSum += arr[i];
                if(tempSum > biggestSum){
                    biggestSum = tempSum;
                    tempEnd = i;
                }
                i++;
            }
            if(biggestSum > sum){
                start = tempStart;
                end =tempEnd;
            }
            i++;
        }

        int[] result = new int[end - start + 1];
        int k = 0;
        for (int j = start; j <= end; j++) {
            result[k] = arr[j];
            k++;
        }

        return result;
    }
}
