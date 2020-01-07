public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0){
            return;
        }
        int count = nums.length < k ? k % nums.length : k;
        int value = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            index = index + count < nums.length ? index + count : index + count - nums.length;

            var temp = nums[index];

            nums[index] = value;

            value = temp;
        }
    }
}
