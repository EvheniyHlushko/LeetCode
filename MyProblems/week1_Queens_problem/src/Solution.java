public class Solution {
    public void setQueens(int[][] arr, int n){
        isSet(arr, 0, 0, n, 0);

    }


    private boolean isSet(int[][]arr,int row, int column, int n, int actual){
        if(actual == n){
            return true;
        }

        for (int i = row; i < arr.length; i++) {
            for (int j = column; j < arr[i].length; j++) {
                if(isSafe(arr, i ,j)){
                    arr[i][j] = 1;
                    if(isSet(arr, i + 1, 0, n, actual + 1)){
                        return true;
                    }
                    arr[i][j] = 0;
                }
            }
            return false;
        }

        return false;
    }

    private boolean isSafe(int[][] arr, int i, int j){

        for (int k = 0; k < arr[i].length; k++){
            if(arr[i][k] == 1){
                return false;
            }
        }

        for(int k = 0; k < arr[i].length; k++){
            if(arr[k][j] == 1){
                return false;
            }
        }

        if(
                !isSafeDiagonal1(arr, i, j)
                || !isSafeDiagonal2(arr, i, j)
                || !isSafeDiagonal3(arr, i, j)
                || !isSafeDiagonal4(arr, i, j)
        ){
            return false;
        }

        return true;

    }

    private boolean isSafeDiagonal1(int[][] arr, int i, int j){
        int k = i;
        int s = j;
        while(k < arr.length && s < arr.length){
            if(arr[k][s] == 1){
                return false;
            }
            k++;
            s++;
        }

        return true;
    }

    private boolean isSafeDiagonal2(int[][] arr, int i, int j){
        int k = i;
        int s = j;
        while(k >= 0 && s >= 0){
            if(arr[k][s] == 1){
                return false;
            }
            k--;
            s--;
        }

        return true;
    }

    private boolean isSafeDiagonal3(int[][] arr, int i, int j){
        int k = i;
        int s = j;
        while(k >= 0 && s < arr.length){
            if(arr[k][s] == 1){
                return false;
            }
            k--;
            s++;
        }

        return true;
    }

    private boolean isSafeDiagonal4(int[][] arr, int i, int j){
        int k = i;
        int s = j;
        while(k < arr.length && s > 0){
            if(arr[k][s] == 1){
                return false;
            }
            k++;
            s--;
        }

        return true;
    }
}
