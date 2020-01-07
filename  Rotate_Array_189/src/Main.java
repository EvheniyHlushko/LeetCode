public class Main {

    public static void main(String[] args) {
	// write your code here
        var solution = new Solution();
        var array = new int[]{1,2,3,4,5,6};
        solution.rotate(array,2);
        for (var item:
             array) {
            System.out.println(item);
        }
    }
}
