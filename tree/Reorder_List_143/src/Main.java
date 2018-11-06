public class Main {
    public static void main(String[] args) {

        var node = new ListNode(1);

        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        /*node.next.next.next.next = new ListNode(5);*/

        printNode(node);

        var solution = new Solution();

        solution.reorderList(node);

        System.out.print("ters");
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
