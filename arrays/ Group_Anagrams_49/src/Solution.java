/*https://leetcode.com/problems/group-anagrams/description

49. Group Anagrams

        Given an array of strings, group anagrams together.

        Example:

        Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
        Output:
        [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
        ]
        Note:

        All inputs will be in lowercase.
        The order of your output does not matter.*/

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String item:
             strs) {
            char[] list = item.toCharArray();
            Arrays.sort(list);
            String result = new String(list);

            if(map.containsKey(result)){
                List<String> key = map.get(result);
                key.add(item);
                continue;
            }

            List<String> value = new ArrayList<String>();

            value.add(item);
            map.put(result, value);

        }

        return new ArrayList(map.values());

    }
}
