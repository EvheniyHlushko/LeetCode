public class Main {

    public static void main(String[] args) {
	// write your code here
        var solution = new Solution();

        LinkedList list = new LinkedList();

        list.append(new Node(null, 1));
        list.append(new Node(null, 2));
        list.append(new Node(null, 3));
        list.append(new Node(null, 4));
        list.append(new Node(null, 5));



        var result = solution.getElements(list);

        System.out.println("first list");

        Node node1 = result[0].head;

        while(node1 != null){
            System.out.print(node1.data + ",");
            node1 = node1.next;
        }

        System.out.println("second list");

        Node node2 = result[1].head;

        while(node2 != null){
            System.out.print(node2.data + ",");
            node2 = node2.next;
        }
    }
}
