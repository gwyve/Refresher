package OJ.LeetCode.Num101_150;

import java.util.*;

public class Num107BinaryTreeLevelOrderTraversalII {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    private TreeNode createTree(int[] nums){
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


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 这个题一开始竟然想的是用两个stack，这个问题就有点严重了，需要对比一下什么时候用stack什么时候用queue
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;

        // queue在java中用linkedlist
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            // 先固定下来一个size是个重点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left!=null)
                    queue.add(tmp.left);
                if (tmp.right!=null)
                    queue.add(tmp.right);
            }
            stack.add(list);
        }


        while (!stack.empty()){
            res.add(stack.pop());
        }
        return res;

    }


    public static void main(String[] args){
        Num107BinaryTreeLevelOrderTraversalII obj = new Num107BinaryTreeLevelOrderTraversalII();
        TreeNode root = obj.createTree(new int[]{1,2,3,4,-1,-1,5});
        List<List<Integer>> res = obj.levelOrderBottom(root);
        System.out.println("=================");
        for (int i = 0; i < res.size(); i++) {
            List<Integer> tmp = res.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                System.out.print(tmp.get(j) + " ");
            }
            System.out.println();
        }
    }
}