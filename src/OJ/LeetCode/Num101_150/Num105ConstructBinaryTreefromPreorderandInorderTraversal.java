package OJ.LeetCode.Num101_150;

public class Num105ConstructBinaryTreefromPreorderandInorderTraversal {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }



    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 这个题，在leftchildlength上面错了，还是长短+1-1的事儿
        if (preorder.length != inorder.length || preorder.length == 0)
            return null;
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

    }


    public TreeNode helper(int[] preorder, int[] inorder,int preBegin,int preEnd,int inBegin, int inEnd){
        if (preEnd < preBegin || inEnd < inBegin)
            return null;

        int rootPos = 0;
        for (int i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == preorder[preBegin]){
                rootPos = i;
                break;
            }
        }
        int leftChildLength = rootPos - inBegin;
        TreeNode root = new TreeNode(preorder[preBegin]);
        root.left = helper(preorder,inorder,preBegin+1,preBegin+leftChildLength,inBegin,rootPos-1);
        root.right = helper(preorder,inorder,preBegin+leftChildLength+1,preEnd,rootPos+1,inEnd);
        return root;

    }


    public static void main(String[] args){
        Num105ConstructBinaryTreefromPreorderandInorderTraversal obj = new Num105ConstructBinaryTreefromPreorderandInorderTraversal();
        obj.buildTree(new int[]{2,1,3,5,4},new int[]{1,2,3,4,5});
    }
}