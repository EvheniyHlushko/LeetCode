

public class Solution {
    public LinkedList[] getElements(LinkedList list){
        LinkedList oddList = new LinkedList();
        LinkedList evenList = new LinkedList();

        Node node = list.head;
        boolean isOdd = true;
        while (node != null){
            Node temp = node.next;
            node.next = null;
            if(isOdd){
                oddList.append(node);
            }
            else{
                evenList.append(node);
            }
            node = temp;
            isOdd = !isOdd;
        }

        return new LinkedList[]{oddList, evenList};
    }
}


