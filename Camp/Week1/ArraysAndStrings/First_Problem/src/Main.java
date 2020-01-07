public class Main {

    public static void main(String[] args) {
	// write your code here
        var arr = new int[]{1,2,5,6,8,0,0,0};

        var solution = new Solution();

        solution.ReplaceEvenNumber(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
