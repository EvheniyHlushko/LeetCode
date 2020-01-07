public class Main {

    public static void main(String[] args) {
	// write your code here
        var solution = new Solution();

        var arr = new int[]{1,0,1,2,1,0,1,2};
        solution.orderMarbles(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
