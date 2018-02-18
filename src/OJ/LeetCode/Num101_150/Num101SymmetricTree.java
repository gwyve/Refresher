package OJ.LeetCode.Num101_150;

/**
 * Created by yixina-z on 18/2/18.
 */
public class Num101SymmetricTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return mirror(root.left,root.right);
    }
    public boolean mirror(TreeNode p,TreeNode q){
        if ((p==null && q!=null)||(p!=null && q == null))
            return false;
        if (p == null && q == null)
            return true;
        if (p.val != q.val)
            return false;
        return mirror(p.right,q.left) && mirror(p.left,q.right);
    }
}
