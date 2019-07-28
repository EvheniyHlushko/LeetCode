public class Solution {
    public void reverseString(char[] s) {
        int length = s.length/2;
        for (int i = 0; i < length; i++)
        {
            char current = s[i];
            int indexToExchange = s.length - 1 - i;
            s[i] = s[indexToExchange];
            s[indexToExchange] = current;
        }
    }
}
