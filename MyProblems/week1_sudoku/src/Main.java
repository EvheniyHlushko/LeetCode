public class Main {

    public static void main(String[] args) {
	// write your code here

     /*   char[][] arr = new char[][]{
                new char[]{5,3,0,0,7,0,0,0,0},
                new char[]{6,0,0,1,9,5,0,0,0},
                new char[]{0,9,8,0,0,0,0,6,0},
                new char[]{8,0,0,0,6,0,0,0,3},
                new char[]{4,0,0,8,0,3,0,0,1},
                new char[]{7,0,0,0,2,0,0,0,6},
                new char[]{0,6,0,0,0,0,2,8,0},
                new char[]{0,0,0,4,1,9,0,0,5},
                new char[]{0,0,0,0,8,0,0,7,9},
        };*/

        char[][] arr = new char[][]{
                new char[]{3,0,1,6,7,0,0,0,4},
                new char[]{0,0,0,0,3,1,0,0,0},
                new char[]{0,0,0,5,4,0,0,6,0},
                new char[]{0,7,0,0,0,0,0,0,0},
                new char[]{0,0,8,0,0,6,0,7,0},
                new char[]{0,0,6,1,0,0,3,8,2},
                new char[]{6,0,0,4,1,0,0,0,0},
                new char[]{8,0,0,0,6,0,0,0,0},
                new char[]{7,3,0,0,0,0,0,5,1},
        };

        var solution = new Solution();

        solution.solveSudoku(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print((int)arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
