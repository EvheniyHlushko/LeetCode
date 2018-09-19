import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] list = s.toCharArray();
        char[] list2 = t.toCharArray();

        if(s.length() != t.length()){
            return false;
        }

        Arrays.sort(list);
        Arrays.sort(list2);

        for (int i = 0; i < list.length; i++){
            if(list[i] != list2[i]){
                return false;
            }
        }

        return true;
    }

}
