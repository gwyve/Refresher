package OJ.LeetCode.Num201_250;

public class Num222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        // 这个方法没有用到完全二叉树的性质，虽然快，可是并不是出题人的意思
        if (root == null)
            return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}