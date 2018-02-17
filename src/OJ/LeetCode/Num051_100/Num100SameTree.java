package OJ.LeetCode.Num051_100;

/**
 * Created by yixina-z on 18/2/18.
 */
public class Num100SameTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || ( p != null && q == null))
            return false;
        if (p == null && q == null)
            return true;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
