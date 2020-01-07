import java.util.ArrayList;

public class Solution {
    public boolean isPalindrome(String s) {
        char[] array = s.toCharArray();

        int start = 0;
        int finish = array.length - 1;

        while (start < finish){
            while(start < finish && !isAlphabetOrNumeric(array[start])){
                start++;
            }

            if(!isAlphabetOrNumeric(array[start])){
                break;
            }

            while(start < finish && !isAlphabetOrNumeric(array[finish])){
                finish--;
            }

            if(!isAlphabetOrNumeric(array[finish])){
                break;
            }

            if(Character.toUpperCase(array[start]) != Character.toUpperCase(array[finish])){
                return false;
            }

            start++;
            finish--;
        }

        return true;
    }

    private boolean isAlphabetOrNumeric(char c){
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }

    public boolean shouldSkipIndex(int index){

        return !((index > 47 && index <58) || (index > 64 && index < 91) || (index > 96 && index <123));
    }

    public int getLowerCaseInt(int num){
        return num > 64 && num < 91 ? num + 32 : num;
    }
}
