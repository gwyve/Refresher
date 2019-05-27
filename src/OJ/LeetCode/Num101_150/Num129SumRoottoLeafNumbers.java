package OJ.LeetCode.Num101_150;

import java.util.LinkedList;
import java.util.List;

public class Num129SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root,0);

    }
    public int helper(TreeNode root, int cur){
        cur = cur*10 + root.val;
        if (root.left == null && root.right == null){
            return cur;
        }
        int left = 0;
        int right = 0;
        if (root.left != null){
            left = helper(root.left,cur);
        }
        if (root.right != null){
            right = helper(root.right,cur);
        }
        return left+right;
    }


    public static void main(String[] args){
        Num129SumRoottoLeafNumbers obj = new Num129SumRoottoLeafNumbers();
        TreeNode root = obj.createTree(new int[]{4,9,0,5,1});
        System.out.println(obj.sumNumbers(root));
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