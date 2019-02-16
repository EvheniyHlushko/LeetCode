public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();



        int[] result = solution.Intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});

        for (int i :
                result) {
            System.out.print(i + "\n");

        }

        System.out.print(result);
    }
}
