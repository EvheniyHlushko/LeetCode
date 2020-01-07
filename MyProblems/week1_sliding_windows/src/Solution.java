import java.util.HashSet;

public class Solution {
    public String getLongestUniqueSubstring(String s){
        HashSet<Character> set = new HashSet<>();

        char[] charArray = s.toCharArray();

        int start = 0;
        int end = 0;

        int resStart = 0;
        int resEnd = 0;

        while(end < charArray.length - 1){
            if(set.contains(charArray[end])){
                if(end - start > resEnd - resStart){
                    resStart = start;
                    resEnd = end - 1;
                }
                while (set.contains(charArray[end])){
                    set.remove(charArray[start]);
                    start++;
                }
            }
            else{
                set.add(charArray[end]);
                end++;
            }
        }

        if(end - start > resEnd - resStart){
            resStart = start;
            resEnd = end - 1;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = resStart; i <= resEnd; i++) {
            builder.append(charArray[i]);
        }
        return builder.toString();
    }
}
