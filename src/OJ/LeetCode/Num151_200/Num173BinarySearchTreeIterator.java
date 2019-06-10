package OJ.LeetCode.Num151_200;

import java.util.Stack;

public class Num173BinarySearchTreeIterator {

    Stack<TreeNode> stack = new Stack<TreeNode>();

    public Num173BinarySearchTreeIterator(TreeNode root) {
        // 这个是用一个栈解决的
        pushLast(root);
    }
    public void pushLast(TreeNode root){
        if (root == null)
            return;
        pushLast(root.right);
        stack.push(root);
        pushLast(root.left);
    }

    /** @return the next smallest number */
    public int next() {
        return stack.pop().val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        Num173BinarySearchTreeIterator obj = new Num173BinarySearchTreeIterator(root);
        System.out.println(obj.next());
        System.out.println(obj.next());

    }
}