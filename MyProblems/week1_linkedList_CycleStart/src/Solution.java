public class Solution {
    public Node getCycleStart(LinkedList linkedList){

        Node sameNode = getSameNode(linkedList);

        if(sameNode == null){
            return null;
        }

        int length = 1;
        int value = sameNode.data;
        sameNode = sameNode.next;
        while (value != sameNode.data){
            sameNode = sameNode.next;
            length++;
        }

        return getStartNode(linkedList, length);


    }

    private Node getStartNode(LinkedList linkedList, int length){

        Node slow = linkedList.head;
        Node fast = linkedList.head;

        while (length != 0){
            fast = fast.next;
            length--;
        }

        while(slow.data != fast.data){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    private Node getSameNode(LinkedList linkedList){
        if(linkedList.head == null || linkedList.head.next == null){
            return null;
        }

        Node slow = linkedList.head;
        Node fast = slow.next;
        while (slow.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
            }

            if(slow.data == fast.data){
                return slow;
            }
        }

        return null;
    }
}
