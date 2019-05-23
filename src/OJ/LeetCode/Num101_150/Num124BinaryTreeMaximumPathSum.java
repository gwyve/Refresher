package OJ.LeetCode.Num101_150;

public class Num124BinaryTreeMaximumPathSum {

    class Heler{
        int val;
        Heler(int val){
            this.val= val;
        }
    }

    public int maxPathSum(TreeNode root) {
        Heler res = new Heler(Integer.MIN_VALUE);
        if (root == null)
            return res.val;
        helper(root,res);
        return res.val;
    }

    public int helper(TreeNode treeNode, Heler res){
        if (treeNode == null)
            return 0;
        int left = helper(treeNode.left,res);
        // 此处与0进行比较，如果小于0就相当于舍弃掉
        left = left>0?left:0;
        int right = helper(treeNode.right,res);
        right = right>0?right:0;
        // 这个里面其实判断了所有的叶子节点和非叶子节点
        res.val = res.val>(left+right+treeNode.val)?res.val:(left+right+treeNode.val);
        return (left>right?left:right)+treeNode.val;
    }


    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public static void main(String[] args){
        Num124BinaryTreeMaximumPathSum obj = new Num124BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(-3);
        root.right = new TreeNode(-1);
        root.left = new TreeNode(-1);
//        root.left = new TreeNode(9);
//        TreeNode right = new TreeNode(20);
//        root.right = right;
//        right.left = new TreeNode(15);
//        right.right = new TreeNode(7);
        System.out.println(obj.maxPathSum(root));
    }
}