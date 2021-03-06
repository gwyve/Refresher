package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.List;

public class Num144BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }
    public void helper(TreeNode root,List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        helper(root.left,res);
        helper(root.right,res);
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}