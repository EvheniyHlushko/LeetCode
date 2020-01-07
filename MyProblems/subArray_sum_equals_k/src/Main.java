public class Main {

    public static void main(String[] args) {
	    var solution = new Solution();

	    var result = solution.getSubArray(new int[]{2,4,-2,1,-3,5,99}, 3);

        for (int item :
                result) {
            System.out.print(item + ",");
        }
    }
}
