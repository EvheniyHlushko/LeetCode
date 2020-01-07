import java.util.HashMap;

public class Solution {
    HashMap<Integer, Character[]> map = new HashMap<>() {{

        put(2, new Character[]{'A', 'B', 'C'});
        put(3, new Character[]{'D', 'E', 'F'});
        put(4, new Character[]{'G', 'H', 'I'});
        put(5, new Character[]{'J', 'K', 'L'});
        put(6, new Character[]{'M', 'N', 'O'});
        put(7, new Character[]{'P', 'Q', 'R', 'S'});
        put(8, new Character[]{'T', 'U', 'V'});
        put(9, new Character[]{'W', 'X', 'Y', 'Z'});

    }};


    public void printAllCombinations(int[] numbers){
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0 || numbers[i] == 1){
                continue;
            }
            count++;
        }
        Character[][] characters = new Character[count][];

        int idx = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(numbers[i])){
                characters[idx] = map.get(numbers[i]);
                idx++;
            }
        }

        printAll(characters, new Character[characters.length], 0);

    }

    private void printAll(Character[][] characters, Character[] buffer, int elementNumber){
        if(buffer.length == elementNumber){
            printArray(buffer);
            return;
        }

        if(elementNumber == characters.length){
            return;
        }

        for (int i = 0; i < characters[elementNumber].length; i++) {
            buffer[elementNumber] = characters[elementNumber][i];

            printAll(characters, copyArray(buffer), elementNumber + 1);
        }
    }

    private void printArray(Character[] buffer){
        System.out.println();
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i] + ",");
        }
    }

    private Character[] copyArray(Character[] buffer){
        Character[] result = new Character[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            result[i] = buffer[i];
        }

        return result;
    }
}
