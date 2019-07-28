import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
/*
https://leetcode.com/problems/roman-to-integer/
 */
@SuppressWarnings("VariableTypeCanBeExplicit")
public class Solution {


        public int romanToInt(String s) {
            Map<Character, Integer> dic = new HashMap<Character, Integer>() {
                {
                    put('I', 1);
                    put('V', 5);
                    put('X', 10);
                    put('L', 50);
                    put('C', 100);
                    put('D', 500);
                    put('M', 1000);
                }
            };
            char[] charArray = s.toCharArray();
            int sum = 0;
            for (int i = 0; i < charArray.length -1; i++) {
                int value = dic.get(charArray[i]);
                int nextValue = dic.get(charArray[i + 1]);
                value = nextValue > value ? -value : value;

                sum += value;
            }
            return sum + dic.get(charArray[charArray.length - 1]);
        }
}
