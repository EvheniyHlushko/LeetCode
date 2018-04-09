namespace PupulatingNextRightPointers_116
{
//    https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

//    116. Populating Next Right Pointers in Each Node

//    Given a binary tree

//    struct TreeLinkNode
//    {
//      TreeLinkNode* left;
//      TreeLinkNode* right;
//      TreeLinkNode* next;
//    }
//    Populate each next pointer to point to its next right node.If there is no next right node, the next pointer should be     set to NULL.

//    Initially, all next pointers are set to NULL.

//    Note:

//    You may only use constant extra space.
//    You may assume that it is a perfect binary tree(ie, all leaves are at the same level, and every parent has two chi        ldren).
//    For example,
//    Given the following perfect binary tree,
//         1
//       /  \
//      2    3
//     / \  / \
//    4   5 6  7
//    After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \  / \
//     4->5->6->7 -> NULL
  public class Solution
  {
    public void connect(TreeLinkNode root)
    {
      if (root == null) return;

      helper(root.left, root.right);
    }

    private void helper(TreeLinkNode node1, TreeLinkNode node2)
    {
      if (node1 == null) return;

      node1.next = node2;
      helper(node1.left, node1.right);
      helper(node2.left, node2.right);
      helper(node1.right, node2.left);
    }
  }
}