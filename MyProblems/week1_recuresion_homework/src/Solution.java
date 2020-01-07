import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public void printTargetAmount(int[] coins, int sum){
        makeCoinsToGetSum(coins, new Stack<Integer>(), 0, sum, 0);
    }

    private void makeCoinsToGetSum(int[] coins, Stack<Integer> buffer, int currentSum, int sum, int index){


        for (int i = index; i < coins.length; i++){
            if(sum == coins[i] + currentSum){
                buffer.push(coins[i]);
                printArray(buffer);
                buffer.pop();
              //  buffer.clear();
                continue;
            }
            if(coins[i] + currentSum < sum){
                buffer.push(coins[i]);
                makeCoinsToGetSum(coins, buffer, coins[i] + currentSum, sum, i);
                buffer.pop();
                continue;
            }
        }

    }

    private void printArray(Stack<Integer> arr){
        System.out.println();

        for (int item :
                arr) {
         System.out.print(item + ",");
        }
    }

    private ArrayList<Integer> clone(ArrayList<Integer> arr){
        ArrayList<Integer> result = new ArrayList<>();
        for (int item :
                arr) {
            result.add(item);
        }

        return result;
    }
}
