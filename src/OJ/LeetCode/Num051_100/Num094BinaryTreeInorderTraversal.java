package OJ.LeetCode.Num051_100;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yixina-z on 18/2/17.
 */
public class Num094BinaryTreeInorderTraversal {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){this.val = x;}
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        res(ret,root);
        return ret;
    }

    public void res(List<Integer> ret, TreeNode root){
        if (root == null)
            return;
        res(ret,root.left);
        ret.add(root.val);
        res(ret,root.right);
    }
}
