import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/fizz-buzz/
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= n; i++){
            String value = "";
            if(i % 3 == 0){
                value = "Fizz";
            }
            if(i % 5 == 0){
                value += "Buzz";
            }
            if(value.equals("")){
                value = Integer.toString(i);
            }

            result.add(value);
        }

        return result;
    }
}
