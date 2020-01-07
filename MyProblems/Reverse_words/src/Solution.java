public class Solution {
    public String reverseWords(String text){

        char[] array = text.toCharArray();

        int firstStart = 0;
        int firstEnd = GetFirstEnd(array, 0);

        int lastStart = GetLastStart(array, array.length - 1);
        int lastEnd = array.length - 1;

        while (firstEnd < lastStart){

            if(firstEnd == firstStart){
                firstEnd = GetFirstEnd(array, firstStart);
            }
            if(lastEnd == lastStart){
                lastStart = GetLastStart(array, lastEnd);
            }

            char temp = array[firstStart];

            array[firstStart] = array[lastStart];

            array[lastEnd] = array[firstEnd];

            firstStart++;
            firstEnd++;
        }


    }

    private int GetLastStart(char[] array, int end){
        for (int i = end; i > 0; i--) {
               if(array[i] == ' '){
                   return i;
               }
        }

        return 0;
    }

    private int GetFirstEnd(char[] array, int start){
        for (int i = start; i > array.length; i++) {
            if(array[i] == ' '){
                return i;
            }
        }

        return array.length;
    }
}
