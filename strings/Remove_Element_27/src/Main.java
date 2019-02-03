public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = new int[]{0,1,2,2,3,0,4,2};

        int len = solution.removeElement(nums, 2);

        for (int i = 0; i < len; i++)
        {
            System.out.print(nums[i]);
        }
    }
}
