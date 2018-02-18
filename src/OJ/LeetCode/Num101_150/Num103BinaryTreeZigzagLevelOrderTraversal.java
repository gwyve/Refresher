package OJ.LeetCode.Num101_150;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yixina-z on 18/2/18.
 */
public class Num103BinaryTreeZigzagLevelOrderTraversal {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x ){
            val = x;
        }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null)
            return ret;
        if (root.left == null && root.right == null){
            List<Integer> tmp = new LinkedList<Integer>();
            tmp.add(root.val);
            ret.add(tmp);
            return ret;
        }
        Stack<TreeNode> stackFromLeft = new Stack<TreeNode>();
        Stack<TreeNode> stackFromRight = new Stack<TreeNode>();

        List<Integer> tmp = new LinkedList<Integer>();
        tmp.add(root.val);
        ret.add(tmp);

        if (root.left != null)
            stackFromRight.push(root.left);
        if (root.right != null)
            stackFromRight.push(root.right);


        int level = 1;
        while (!stackFromLeft.empty() || !stackFromRight.empty()){
            if (level % 2 ==0){
                tmp = new LinkedList<Integer>();
                while (!stackFromLeft.empty()){
                    TreeNode tmpNode = stackFromLeft.pop();
                    tmp.add(tmpNode.val);
                    if (tmpNode.left != null)
                        stackFromRight.push(tmpNode.left);
                    if (tmpNode.right != null)
                        stackFromRight.push(tmpNode.right);
                }
                ret.add(tmp);
            }else {
                tmp = new LinkedList<Integer>();
                while (!stackFromRight.empty()){
                    TreeNode tmpNode = stackFromRight.pop();
                    tmp.add(tmpNode.val);
                    if (tmpNode.right != null)
                        stackFromLeft.push(tmpNode.right);
                    if (tmpNode.left != null)
                        stackFromLeft.push(tmpNode.left);
                }
                ret.add(tmp);
            }
            level ++;
        }
        return ret;
    }
}
