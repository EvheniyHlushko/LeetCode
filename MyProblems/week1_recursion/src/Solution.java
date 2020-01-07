import java.util.HashMap;

public class Solution {
    public int calculatePower(int x, int n){
        HashMap<Integer, Integer> map = new HashMap<>();

        return calculatePowerInternal(x, n, map);
    }

    private int calculatePowerInternal(int x, int n, HashMap<Integer, Integer> map){
        if(n == 1){
            return x;
        }

        if(n == 0){
            return 1;
        }


        if(map.containsKey(n)){
            return map.get(n);
        }

        int result;

        if(n % 2 == 0){
            result = calculatePowerInternal(x, n/2, map) * calculatePowerInternal(x, n/2, map);
        }
        else{
            result = calculatePowerInternal(x, n/2, map) * calculatePowerInternal(x, n/2 + 1, map);
        }

        map.put(n, result);

        return result;
    }
}
