package SwordPointOffer;

import java.util.Arrays;

/**
 * Created by VE on 2017/2/13.
 */
public class Num06ConstructBinaryTree {

    class Node{
        int value;
        Node LeftChild = null;
        Node RightChild = null;
        Node(int value){
            this.value = value;
        }
    }

    Node Construct(int[] preOrder,int[] inOrder){
        if (preOrder.length != inOrder.length || preOrder.length ==0)
            return null;
        else
            return ConstructCore(preOrder, inOrder);
    }

    Node ConstructCore(int[] preOrder,int[] inOrder){
        if (preOrder.length != inOrder.length || preOrder.length ==0)
            return null;
        int length = preOrder.length;

        Node root = new Node(preOrder[0]);
        if (length == 1)
            return root;

        //查找中序遍历中root的位置
        int rootIndex = 0;
        for (;rootIndex<inOrder.length;rootIndex++){
            if (preOrder[0] == inOrder[rootIndex])
                break;
        }
        if (rootIndex > 0){
            root.LeftChild = ConstructCore(Arrays.copyOfRange(preOrder,1,rootIndex + 1),
                    Arrays.copyOfRange(inOrder,0,rootIndex));
        }
        if (rootIndex < length -1){
            root.RightChild = ConstructCore(Arrays.copyOfRange(preOrder,rootIndex+1,length),Arrays.copyOfRange(inOrder,rootIndex+1,length));
        }
        return root;

    }

    public void printHead(Node root){
        if (root != null){
            if (root.LeftChild != null || root.RightChild != null){
                System.out.print(root.value + "  ");
                printHead(root.LeftChild);
                printHead(root.RightChild);
            }
        }
    }


    public static void main(String arg[]){

        Num06ConstructBinaryTree obj = new Num06ConstructBinaryTree();
        Node root = obj.Construct(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});
        obj.printHead(root);
    }

}
