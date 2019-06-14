package OJ.LeetCode.Num151_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num199BinaryTreeRightSideView {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        while ( (!queue1.isEmpty()) || (!queue2.isEmpty())){
            if (!queue1.isEmpty()){
                while (!queue1.isEmpty()){
                    TreeNode tmp = queue1.poll();
                    if (tmp.left!= null)
                        queue2.add(tmp.left);
                    if (tmp.right!=null)
                        queue2.add(tmp.right);
                    if (queue1.isEmpty())
                        res.add(tmp.val);
                }
            }
            if (!queue2.isEmpty()){
                while (!queue2.isEmpty()){
                    TreeNode tmp = queue2.poll();
                    if (tmp.left!=null)
                        queue1.add(tmp.left);
                    if (tmp.right != null)
                        queue1.add(tmp.right);
                    if (queue2.isEmpty())
                        res.add(tmp.val);
                }
            }
        }
        return res;
    }



    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }


}