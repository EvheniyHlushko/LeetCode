public class Solution {
    public int getChangeCombinationNumber(int[] coins, int sum){
        Ref<Integer> result = new Ref<Integer>(0);

        getSum(coins, 0, sum, result, 0);

        return result.Value;
    }


    private void getSum(int[] coins, int current, int expected, Ref<Integer> result, int idx){
        for (int i = idx; i < coins.length; i++) {
            int sum = current + coins[i];
            if(sum > expected){
                continue;
            }
            if(sum < expected){
                getSum(coins, sum, expected, result, i);
                continue;
            }
            result.Value++;
        }
    }
}


class Ref<T>
{
    public T Value;

    public Ref(T value)
    {
        Value = value;
    }
}
