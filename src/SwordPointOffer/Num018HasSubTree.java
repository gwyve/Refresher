package SwordPointOffer;

/**
 * Created by VE on 2017/3/9.
 */
public class Num018HasSubTree {
    private  class BinaryTreeNode{
        int value;
        BinaryTreeNode leftNode;
        BinaryTreeNode rightNode;
    }

    public boolean DoesTree1HasTree2(BinaryTreeNode pRoot1,BinaryTreeNode pRoot2){
        if (pRoot2 == null)
            return true;
        if (pRoot1 == null)
            return false;
        if (pRoot1.value != pRoot2.value)
            return false;

        return DoesTree1HasTree2(pRoot1.leftNode,pRoot2) && DoesTree1HasTree2(pRoot1.rightNode,pRoot2);
    }

    public boolean HasSubTree(BinaryTreeNode pRoot1,BinaryTreeNode pRoot2){
        boolean res = false;
        if (pRoot1 != null && pRoot2 != null){
            if (pRoot1.value == pRoot2.value)
                res = DoesTree1HasTree2(pRoot1,pRoot2);
            if (!res)
                res = HasSubTree(pRoot1.leftNode,pRoot2);
            if (!res)
                res = HasSubTree(pRoot1.rightNode,pRoot2);
        }
        return res;
    }

}
