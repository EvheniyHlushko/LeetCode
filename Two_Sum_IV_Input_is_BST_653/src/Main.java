public class Main {

    public static void main(String[] args) {
	   var solution = new Solution();

	   var node = new TreeNode(5);

	   node.left = new TreeNode(3);
	   node.left.right = new TreeNode(4);
	   node.left.left = new TreeNode(2);

	   node.right = new TreeNode(6);

	   node.right.right = new TreeNode(7);

	   var result = solution.findTarget(node, 9);

	   System.out.println(result);
    }
}
