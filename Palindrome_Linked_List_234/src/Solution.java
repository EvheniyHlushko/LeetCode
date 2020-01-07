import java.util.ArrayList;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> array = new ArrayList<>();

        while(head != null){
            array.add(head.val);

            head = head.next;
        }

        int left = 0;
        int right = array.size() - 1;

        int[] arr = array.stream().mapToInt(i -> i).toArray();

        while (left < right){
            if(arr[left] != arr[right]){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
