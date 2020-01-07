public class Main {

    public static void main(String[] args) {
	// write your code here

        var solution = new Solution();

        var result = solution.getPairs1(new int[]{6,3,5,2,1,7},4);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
