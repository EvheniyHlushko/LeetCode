import java.util.HashMap;

public class Solution {

    public int[] getSubArray(int[] arr, int k){
        //int[] sums = new int[arr.length];
        int sum = 0;
        /*for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sums[i] = sum;
        }*/

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int first = -1;
        int second = -1;

        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum == k){
                first = 0;
                second = 1;
                break;
            }
          //  int diff1 = sums[i] + k;
            int diff2 = sum - k;
            /*if(map.containsKey(diff1)){
                first = map.get(diff1);
                second = i;
                break;
            }*/
            if(map.containsKey(diff2)){
                first = map.get(diff2) + 1;
                second = i;
                break;
            }
            else{
                map.put(sum, i);
            }
        }

        if(first == -1){
            return new int[]{};
        }

        int j = 0;
        int[] result = new int[second - first + 1];
        for (int i = first; i <= second; i++){
            result[j] = arr[i];
            j++;
        }
        return result;
    }
}
