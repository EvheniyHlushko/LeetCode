/*https://leetcode.com/problems/valid-parentheses/description/

// 20. Valid Parentheses

        Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Note that an empty string is also considered valid.

        Example 1:

        Input: "()"
        Output: true
        Example 2:

        Input: "()[]{}"
        Output: true
        Example 3:

        Input: "(]"
        Output: false
        Example 4:

        Input: "([)]"
        Output: false
        Example 5:

        Input: "{[]}"
        Output: true*/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();


        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        char[] list = s.toCharArray();

        Stack<Character> stack = new Stack<Character>();

        for(Character item : list){
            if(map.containsKey(item)){
                var value = stack.isEmpty() ? '*' : stack.pop();

                if(value != map.get(item)){
                    return false;
                }

                continue;
            }
            stack.push(item);
        }

        return stack.isEmpty();
    }
}
