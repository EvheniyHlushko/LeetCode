import java.util.ArrayList;

public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;

        for (int i = 0; i < prices.length - 1; i++) {

            if (prices[i] < prices[i+1]) {
                sum += prices[i+1] - prices[i];

            }
        }

        return sum;
    }

//    private void calculate(int[] prices, int start, int sum)
//    {
//        for (int i = start; i < prices.length; i++)
//        {
//
//            if(prices[start] < prices[i])
//            {
//                sum += prices[i] - prices[start];
//
//                if(prices[i] < prices.length - 1)
//                {
//                    calculate(prices, i++, sum, results);
//                }
//            }
//
//            if(i == prices.length - 1)
//            {
//                results.add(sum);
//            }
//        }
//    }
}
