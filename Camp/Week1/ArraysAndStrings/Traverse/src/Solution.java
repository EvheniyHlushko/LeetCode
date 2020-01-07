public class Solution {
    public String ReverseSentence(String sentence){
        var charArray = sentence.toCharArray();
        var currentWorldEnd = charArray.length - 1;
        var builder = new StringBuilder();
        for (int i = charArray.length - 1; i > 0; i--) {
            if(charArray[i] == ' '){
                builder.append(' ');
                builder.append(sentence.substring(i, currentWorldEnd + 1));
                currentWorldEnd = i - 1;
            }
        }

        builder.append(' ');
        builder.append(sentence.substring(0, currentWorldEnd + 1));

        builder.replace(0, 1, "");

        return builder.toString();
    }
}
