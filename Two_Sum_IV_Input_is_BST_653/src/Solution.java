import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        /*while(root != null){
            if(root.right != null){
                root = root.right;
            }
            stack.add(root);

        }*/

        ArrayList<Integer> list = new ArrayList<>();



        populateNodes(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if(containsSum(k, i, list)){
                return true;
            }
        }

        return false;
    }

    private boolean containsSum(int sum, int index, ArrayList<Integer> list){
        int value = list.get(index);
        for (int i = index + 1; i < list.size(); i++) {
            if(list.get(i) + value == sum){
                return true;
            }
        }

        return false;
    }


    public void populateNodes(TreeNode node, ArrayList<Integer> result){
        if(node.left != null){
            populateNodes(node.left, result);
        }

        result.add(node.val);

        if(node.right != null){
            populateNodes(node.right, result);
        }
    }
}
