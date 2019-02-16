public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] result = solution.searchRange(new int[]{0,1,2,3,4,4,4}, 2);

        System.out.print(result[0] + "....");
        System.out.print(result[1]);
    }
}
