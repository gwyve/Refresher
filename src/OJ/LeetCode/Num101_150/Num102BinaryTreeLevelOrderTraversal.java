package OJ.LeetCode.Num101_150;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yixina-z on 18/2/18.
 */
public class Num102BinaryTreeLevelOrderTraversal {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        res(ret,root,0);
        return ret;
    }

    public void res(List<List<Integer>> ret,TreeNode root,int level){
        if (root == null)
            return;
        if (ret.size()<=level)
            ret.add(new LinkedList<Integer>());
        ret.get(level).add(root.val);
        res(ret,root.left,level+1);
        res(ret,root.right,level+1);
    }
}
