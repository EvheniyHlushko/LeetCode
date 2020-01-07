public class Main {

    public static void main(String[] args) {
	// write your code here
        var solution = new Solution();

        int[][] arr = new int[8][8];

        solution.setQueens(arr, 9);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
