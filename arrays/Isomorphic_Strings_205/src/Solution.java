/*https://leetcode.com/problems/isomorphic-strings/description/

205. Isomorphic Strings


        Given two strings s and t, determine if they are isomorphic.

        Two strings are isomorphic if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

        Example 1:

        Input: s = "egg", t = "add"
        Output: true
        Example 2:

        Input: s = "foo", t = "bar"
        Output: false
        Example 3:

        Input: s = "paper", t = "title"
        Output: true
        Note:
        You may assume both s and t have the same length.*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] list = s.toCharArray();
        char[] list2 = t.toCharArray();

        Integer num = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();

        for (int i = 0; i < list.length; i++){
            if(map.containsKey(list[i]) && map2.containsKey(list2[i]) && map.get(list[i]) == map2.get(list2[i])){
                continue;
            }

            if(!map.containsKey(list[i]) && !map2.containsKey(list2[i])){
                num++;
                map.put(list[i], num);
                map2.put(list2[i], num);
                continue;
            }

            return false;


        }

        return true;

    }
}
