public class Main {

    public static void main(String[] args) {
        var solution = new Solution();

        LinkedList list = new LinkedList();

        Node start = new Node(null, 2);
        Node end = new Node(start, 5);

        list.append(new Node(null, 1));
        list.append(start);
        list.append(new Node(null, 3));
        list.append(new Node(null, 4));
        list.append(end);



        var result = solution.getCycleStart(list);

        System.out.print(result.data);
    }
}
