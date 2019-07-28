public class Main {

    public static void main(String[] args) {
	    var solution = new Solution();

	    var first = new ListNode(1);
	    first.next = new ListNode(2);
	    first.next.next = new ListNode(3);
	    first.next.next.next = new ListNode(4);
	    first.next.next.next.next = new ListNode(5);

	    var result = solution.reverseList(first);

	    while (result != null){
	        System.out.println(result.val);
	        result = result.next;
        }
    }
}
