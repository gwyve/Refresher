package OJ.LeetCode.Num101_150;

import sun.util.locale.LocaleSyntaxException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Num113PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        helper(root,sum,new ArrayList<Integer>(),res);
        return res;
    }
    public void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res){
        if (root == null)
            return ;
        if (root.left == null && root.right == null){
            if (sum - root.val == 0){
                list.add(root.val);
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size()-1);
            }
        }
        if (root.left!=null){
            list.add(root.val);
            helper(root.left,sum-root.val,list,res);
            list.remove(list.size()-1);
        }
        if (root.right!=null){
            list.add(root.val);
            helper(root.right,sum-root.val,list,res);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args){
        Num113PathSumII obj = new Num113PathSumII();
        TreeNode root = obj.createTree(new int[]{5,4,8,11,-1,13,4,7,2,-1,-1,5,1});
        List<List<Integer>> res = obj.pathSum(root,22);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
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
            if (list.get(curIndex)!=null)
                list.get(curIndex).left = left;
            list.add(left);
            if (list.get(curIndex)!=null)
                list.get(curIndex).right = right;
            list.add(right);
            curIndex++;
        }
        return list.get(0);
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
}