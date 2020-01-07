import java.util.HashSet;

public class Solution {
    public String getLongestSubstring(String value){
        char[] charArray = value.toCharArray();
        int start = 0;
        int end = 0;

        StringBuilder builder = new StringBuilder();

        HashSet<Character> hashSet = new HashSet<>();

        String longest = "";
        while(charArray.length > start){
            if(hashSet.contains((Character) charArray[end])){
                if(builder.length() > longest.length()){
                    longest = builder.toString();
                }
                Character charValue = builder.charAt(0);
                hashSet.remove(charValue);
                builder.deleteCharAt(0);
                start++;
            }
            else{
                hashSet.add(charArray[end]);
                builder.append(charArray[end]);

                end++;
                if(end >= charArray.length){
                    break;
                }

            }
        }

        return builder.length() > longest.length() ? builder.toString() : longest;
    }
}
