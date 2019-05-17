package OJ.LeetCode.Num101_150;

import OJ.LeetCode.Num051_100.Num099RecoverBinarySearchTree;

public class Num106ConstructBinaryTreefromInorderandPostorderTraversal {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length)
            return null;
        return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);

    }

    public TreeNode helper(int[] inorder,int[] postorder,int inBegin,int inEnd,int postBegin,int postEnd){
        if (inBegin>inEnd || postBegin>postEnd)
            return null;
        int rootPos = 0;
        int rootVal = postorder[postEnd];
        for (int i = inBegin; i <= inEnd ; i++) {
            if (inorder[i] == rootVal){
                rootPos = i;
                break;
            }
        }
        int leftChildLength = rootPos - inBegin;
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = helper(inorder,postorder,inBegin,rootPos-1,postBegin,postBegin+leftChildLength-1);
        root.right = helper(inorder,postorder,rootPos+1,inEnd,postBegin+leftChildLength,postEnd-1);
        return root;

    }


}