import java.util.ArrayList;
/*https://leetcode.com/problems/min-stack/*/

class Node{
    Node next;
    int value;
    int min;
    public Node (int value, int min){
        this.value = value;
        this.min = min;
    }
}
class MinStack {

    Node head;
    public MinStack() {

    }

    public void push(int x) {
        if(head == null){
            head = new Node(x, x);
            return;
        }

        Node node = new Node(x, Math.min(x, head.min));

        node.next = head;

        head = node;

    }

    public void pop() {
        head = head.next;
    }

    public int top() {
       return head.value;
    }

    public int getMin() {
       return head.min;
    }
}
