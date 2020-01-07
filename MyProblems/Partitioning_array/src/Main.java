public class Main {

    public static void main(String[] args) {
	    var solution = new Solution();
        var array = new int[]{1,0,1,2,1,0,1,2};
	    solution.sortByColors(array);
        for (int item :
                array) {
            System.out.print(item + ",");
        }

    }
}
