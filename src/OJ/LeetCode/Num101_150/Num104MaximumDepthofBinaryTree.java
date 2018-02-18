package OJ.LeetCode.Num101_150;

/**
 * Created by yixina-z on 18/2/18.
 */
public class Num104MaximumDepthofBinaryTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public int maxDepth(TreeNode root) {
        return res(root,0);
    }
    public int res(TreeNode root, int level){
        if (root == null){
            return level;
        }else{
            int left = res(root.left,level + 1);
            int right = res(root.right,level+1);
            if (left> right)
                return left;
            else
                return right;
        }
    }
}
