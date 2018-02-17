package OJ.LeetCode.Num051_100;

/**
 * Created by yixina-z on 18/2/17.
 */
public class Num098ValidateBinarySearchTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public boolean isValidBST(TreeNode root) {
        return  isValidBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    public boolean isValidBST(TreeNode root, long max, long min){
        if (root == null)
            return true;
        if (root.val >= max || root.val <= min)
            return false;
        return isValidBST(root.left,root.val,min) && isValidBST(root.right,max,root.val);
    }


}
