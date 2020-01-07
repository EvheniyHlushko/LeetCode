import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;


public class Solution {

    public void solveSudoku(char[][]board){


        HashSet<Character>[] sets = new HashSet[10];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] rows = new HashSet[9];
        initializeSets(sets);
        initializeSets(columns);
        initializeSets(rows);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] ==0){
                    continue;
                }
                columns[j].add(board[i][j]);
                rows[i].add(board[i][j]);
                int num = definePart(i,j);
                sets[num].add(board[i][j]);
            }
        }

        populateArray(board, 0, 0, sets, columns, rows);
    }

    private boolean populateArray(char[][] arr, int first, int second, HashSet<Character>[] sets, HashSet<Character>[] columns, HashSet<Character>[] rows){
        for (int i = first; i < arr.length; i++) {
            for (int j = second; j < arr[i].length; j++) {

                if(j == arr[i].length - 1 && arr[i][j] != 0){
                    return populateArray(arr, first + 1, 0, sets, columns, rows);
                }

                if(arr[i][j] != '.'){
                    continue;
                }


                HashSet<Character> row = rows[i];
                HashSet<Character> column = columns[j];
                int num = definePart(i,j);
                HashSet<Character> set = sets[num];

                ArrayList<Character> values = getPossibleValues(i, j, set, column, row);
                if(values.size() == 0){
                    return false;
                }
                for (Character value :
                        values) {
                     arr[i][j] = value;
                    row.add(value);
                     set.add(value);
                     column.add(value);
                     if(j < arr[i].length - 1){
                         second = j + 1;
                         first = i;
                     }
                     else{
                         second = 0;
                         first = i + 1;
                     }
                     if(populateArray(arr, first, second, sets, columns, rows)){
                         return true;
                     }
                     row.remove(value);
                     set.remove(value);
                     column.remove(value);
                     arr[i][j] = 0;
                }
                return false;

            }
        }
        return true;
    }

    public int definePart(int i, int j){
        int num = definePart1(i) + definePart2(j);
        return num;
    }

    public int definePart1(int i){
        if(i >= 0 && i <= 2){
            return 0;
        }

        if(i >= 3 && i <= 5){
            return 3;
        }

        if(i >= 6 && i <= 8){
            return 6;
        }

        return 0;
    }

    public int definePart2(int i){
        if(i >= 0 && i <= 2){
            return 1;
        }

        if(i >= 3 && i <= 5){
            return 2;
        }

        if(i >= 6 && i <= 8){
            return 3;
        }

        return 0;
    }


    public void initializeSets(HashSet<Character>[] sets){
        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet<>();
        }
    }


    private ArrayList<Character> getPossibleValues(int i , int j,  HashSet<Character> set,  HashSet<Character>  column,  HashSet<Character> row){

        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, '1');
        map.put(2, '2');
        map.put(3, '3');
        map.put(4, '4');
        map.put(5, '5');
        map.put(6, '6');
        map.put(7, '7');
        map.put(8, '8');
        map.put(9, '9');
        ArrayList<Character> result = new ArrayList<>();
        for (int k = 1; k < 10; k++) {
            char value = map.get(k);
            if(row.contains(value) || column.contains(value) || set.contains(value)){
                continue;
            }
            result.add(value);
        }

        for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
            char value = c;
            if(row.contains(value) || column.contains(value) || set.contains(value)){
                continue;
            }
            result.add(value);
        }

        return result;
    }
}

