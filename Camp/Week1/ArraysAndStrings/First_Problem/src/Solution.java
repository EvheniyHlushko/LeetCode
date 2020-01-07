/* Given an array of numbers,
         replace each even number with two of the same number. e.g, [1,2,5,6,8] -> [1,2,2,5,6,6,8,8].
         Assume that the array has enough space to accommodate the result.*/

public class Solution {
    public void ReplaceEvenNumber(int[] array){
        int currentToSet = array.length - 1;
        for (int i = array.length - 1; i > 0 ; i--) {
            if(array[i] == 0){
                continue;
            }

            if(array[i] % 2 == 0){
                array[currentToSet] = array[i];
                currentToSet--;
                array[currentToSet] = array[i];
                currentToSet--;
            }
            else{
                array[currentToSet] = array[i];
                currentToSet--;
            }
        }
    }
}
