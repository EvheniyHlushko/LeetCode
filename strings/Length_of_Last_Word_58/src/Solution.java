/*https://leetcode.com/problems/length-of-last-word/description/
        58. Length of Last Word

        Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

        If the last word does not exist, return 0.

        Note: A word is defined as a character sequence consists of non-space characters only.

        Example:

        Input: "Hello World"
        Output: 5*/

public class Solution {
    public int lengthOfLastWord(String s) {
        char[] list = s.toCharArray();


        int num = 0;
        for(Integer i = list.length - 1; i>= 0; i--) {
            if (list[i] == ' ') {

                if(num == 0){
                    continue;
                }

                return num;
            }

            num++;
        }


        return num;
    }
}
