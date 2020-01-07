public class Main {

    public static void main(String[] args) {
	    var solution = new Solution();

	    var result = solution.getShortestSortedSubArray(new int[]{1,2,4,5,3,5,6,7,9});

        for (var item :
                result) {
            System.out.println(item);
        }
    }
}
