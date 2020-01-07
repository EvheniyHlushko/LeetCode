public class Main {

    public static void main(String[] args) {
	    var array = new int[4][4];

	    array[0] = new int[]{0,1,0,0,0};
	    array[1] = new int[]{0,0,0,1,0};
	    array[2] = new int[]{1,1,1,1,0};
	    array[3] = new int[]{1,1,0,0,0};

	    var solution = new Solution();

	    var result = solution.pathExists(array);

	    System.out.println(result);
    }


}
