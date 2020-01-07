public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void append(Node toAdd) {
        if (head == null) {
            head = toAdd;
        } else {
            tail.setNext(toAdd);
        }
        tail = toAdd;
    }
}
