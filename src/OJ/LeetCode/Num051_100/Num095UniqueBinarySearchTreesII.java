package OJ.LeetCode.Num051_100;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yixina-z on 18/2/17.
 */
public class Num095UniqueBinarySearchTreesII {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public List<TreeNode> generateTrees(int n){
        if (n==0)
            return new LinkedList<TreeNode>();
        return genTree(1,n);
    }
    public List<TreeNode> genTree(int start,int end){
        List<TreeNode> list = new LinkedList<TreeNode>();
        if (start> end){
            list.add(null);
            return list;
        }
        if (start == end){
            list.add(new TreeNode(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = genTree(start,i-1);
            List<TreeNode> right = genTree(i+1,end);

            for (TreeNode lnode : left){
                for(TreeNode rnode : right){
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = lnode;
                    tmp.right = rnode;
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}
