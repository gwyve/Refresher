package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.List;

public class Num145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }
    public void helper(TreeNode root,List<Integer> res){
        if (root == null)
            return;
        helper(root.left,res);
        helper(root.right,res);
        res.add(root.val);
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}