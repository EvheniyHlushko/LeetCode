public class Main {
    public static void main(String[] args) {

        var node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);

        var solution = new Solution();

        solution.deleteNode(node.next);

        printNode(node);
    }

    private static void printNode(ListNode node){

        var printNode = node;

        while(printNode != null){
            System.out.print(printNode.val);
            printNode = printNode.next;
        }

    }
}
