package OJ.LeetCode.Num101_150;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num110BalancedBinaryTree {


    public boolean isBalanced1(TreeNode root){
        // 这个是上一个的优化
        // 如果发现一个子树是不平衡的，那么直接返回-1，不用多次迭代了
        if (root==null)
            return true;
        int left = checkBalanced(root.left);
        if (left == -1)
            return false;
        int right = checkBalanced(root.right);
        if (right == -1)
            return false;
        if (left-right>1 || right-left>1)
            return false;
        else
            return true;
    }
    public int checkBalanced(TreeNode root){
        if (root == null)
            return 0;
        int left = checkBalanced(root.left);
        if (left == -1)
            return -1;
        int right = checkBalanced(root.right);
        if (right == -1)
            return -1;
        if (left-right>1 || right-left>1)
            return -1;
        return left>right?left+1:right+1;
    }


    public boolean isBalanced(TreeNode root) {
        // 这个方法就是迭代，费时
        if (root == null)
            return true;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left-right>1 || right-left>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int helper(TreeNode root){
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        return left>right?left+1:right+1;
    }

    public static void main(String[] args){
        Num110BalancedBinaryTree obj = new Num110BalancedBinaryTree();
        TreeNode root = obj.createTree(new int[]{1,2,2,3,-1,-1,3,4,-1,-1,4});
        System.out.println(obj.isBalanced(root));
    }

    private TreeNode createTree(int[] nums){
        List<TreeNode> list = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(nums[0]);
        int curIndex = 0;
        list.add(root);
        for (int i = 1; i < nums.length; i+=2) {
            TreeNode left = new TreeNode(nums[i]);
            if (nums[i] == -1)
                left = null;
            TreeNode right = new TreeNode(nums[i+1]);
            if (nums[i+1] == -1)
                right = null;

            list.get(curIndex).left = left;
            list.add(left);
            list.get(curIndex).right = right;
            list.add(right);
            curIndex++;
        }
        return list.get(0);
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
}