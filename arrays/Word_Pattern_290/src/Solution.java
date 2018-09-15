import java.util.ArrayList;
import java.util.HashMap;
/*
https://leetcode.com/problems/word-pattern/description/
Given a pattern and a string str, find if str follows the same pattern.

        Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

        Example 1:

        Input: pattern = "abba", str = "dog cat cat dog"
        Output: true
        Example 2:

        Input:pattern = "abba", str = "dog cat cat fish"
        Output: false
        Example 3:

        Input: pattern = "aaaa", str = "dog cat cat dog"
        Output: false
        Example 4:

        Input: pattern = "abba", str = "dog dog dog dog"
        Output: false
        Notes:
        You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.*/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        ArrayList<String> patterns = new ArrayList<String>();

        HashMap<Character, String> hash = new HashMap<Character, String>();
        int j = -1;
        char[] array = str.toCharArray();
        char[] patternArray = pattern.toCharArray();
        for (int i = 0; i < array.length; i++){
            j++;

            if(patternArray.length - 1 < j){
                return false;
            }
            StringBuilder builder = new StringBuilder();
            while (i < array.length && array[i] != ' '){
                builder.append(array[i]);
                i++;
            }

           // i++;
            String result = builder.toString();

            if(!hash.containsKey(patternArray[j]) && !hash.containsValue(result)){
                hash.put(patternArray[j], result);
                continue;
            }

            if(!hash.containsKey(patternArray[j]) || !hash.get(patternArray[j]).equals(result)){
                return false;
            }


        }
        return j >= patternArray.length - 1;
    }
}
