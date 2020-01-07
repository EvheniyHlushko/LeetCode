public class Main {

    public static void main(String[] args) {
	    var solution = new Solution();

	    var array = new int[]{5,2,4,4,6,4,4,3};

	    solution.rearrangeElements(array, 4);

        for (int item :
                array) {
            System.out.print(item + ",");
        }
    }
}
