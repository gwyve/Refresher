package OJ.LeetCode.Num101_150;

import java.util.LinkedList;
import java.util.List;

public class Num108ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null || nums.length==0)
            return null;
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums,int low,int high){
        if (low>high)
            return null;
        if (low == high)
            return new TreeNode(nums[low]);
        int mid = (low+high)/2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = helper(nums,low,mid-1);
        res.right = helper(nums,mid+1,high);
        return res;
    }


    public static void main(String[] args){
        Num108ConvertSortedArraytoBinarySearchTree obj = new Num108ConvertSortedArraytoBinarySearchTree();
        TreeNode root = obj.sortedArrayToBST(new int[]{-10,-3,0,5,9});

    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
}