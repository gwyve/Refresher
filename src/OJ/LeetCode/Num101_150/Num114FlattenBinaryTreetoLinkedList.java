package OJ.LeetCode.Num101_150;

import java.util.LinkedList;
import java.util.Queue;

public class Num114FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        // 这个题一开始理解错了，跟排序无关
        if (root==null)
            return;
        if (root.left!=null)
            flatten(root.left);
        if (root.right!=null)
            flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right!=null){
            root = root.right;
        }
        root.right = tmp;
    }


    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

}