public class Main {

    public static void main(String[] args) {
	    var solution = new Solution();

	    var result = solution.getSubArrayWithLargestSum(new int[]{-2,-3,4,-1,-2,1,5,-1});

        for (int item :
                result) {
            System.out.print(item + ",");
        }
    }
}
