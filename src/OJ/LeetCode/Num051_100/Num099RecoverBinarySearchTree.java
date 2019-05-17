package OJ.LeetCode.Num051_100;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Num099RecoverBinarySearchTree {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    public void recoverTree(TreeNode root) {
        // 这个题还是需要去想到 二叉搜索树 与 中序遍历 的关系，想到这一层就对了
        if (root == null)
            return;
        List<TreeNode> list = new ArrayList<TreeNode>();
        List<Integer> vals = new ArrayList<Integer>();
        inSort(root,list,vals);
        Collections.sort(vals);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).val = vals.get(i);
        }
    }

    public void inSort(TreeNode root,List<TreeNode> treeNodes,List<Integer> vals){
        if (root==null)
            return;
        inSort(root.left,treeNodes,vals);
        treeNodes.add(root);
        vals.add(root.val);
        inSort(root.right,treeNodes,vals);
    }





    public TreeNode createTree(int[] nums){
        List<TreeNode> list = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(nums[0]);
        int curIndex = 0;
        list.add(root);
        for (int i = 1; i < nums.length; i+=2) {
            TreeNode left = new TreeNode(nums[i]);
            if (nums[i] == -1)
                left = null;
            TreeNode right = new TreeNode(nums[i+1]);
            if (nums[i+1] == -1)
                right = null;

            list.get(curIndex).left = left;
            list.add(left);
            list.get(curIndex).right = right;
            list.add(right);
            curIndex++;
        }
        return list.get(0);
    }

    public static void main(String[] args){
        Num099RecoverBinarySearchTree obj = new Num099RecoverBinarySearchTree();
        TreeNode root = obj.createTree(new int[]{1,3,-1,-1,2});
        obj.recoverTree(root);

    }

}