package DataStruct.tree;

import java.util.Map;

/**
 * Created by VE on 2017/5/3.
 */
public class AVLTree {
    //Adelson-Velskii and Landis
    // 带有平衡条件的树

    private class Node{
        int value;
        Node leftChild;
        Node rightChild;
        int height;
        Node(int x){
            this.value = x;
            this.height = 1;
        }

    }

    private int getHeight(Node node){
        if (node == null){
            return -1;
        }else {
            return node.height;
        }
    }

    private void insert(int x ,Node node){
        if (node == null){
            node = new Node(x);
        }else if(x < node.value){
            insert(x,node.leftChild);
            if (getHeight(node.leftChild) - getHeight(node.rightChild) == 2){
                if (x < node.leftChild.value){
                    node = singleRotation(node);
                }else if (x > node.leftChild.value){
                    node = doubleRotation(node);
                }
            }
        }else if(x > node.value){
            insert(x,node.rightChild);
            if (getHeight(node.rightChild) - getHeight(node.leftChild) == 2){
                if ( x < node.rightChild.value){
                    node = doubleRotation(node);
                }else if (x > node.leftChild.value){
                    node = singleRotation(node);
                }
            }
        }else {
            // do nothing
        }

        node.height = Math.max(getHeight(node.leftChild),getHeight(node.rightChild)) + 1;
    }

    // 单旋转
    private Node singleRotation(Node node){
        Node k2 = node;
        if (getHeight(node.leftChild) > getHeight(node.rightChild)){
            Node k1 = node.leftChild;
            k2.leftChild = k1.rightChild;
            k1.rightChild = k2;
            k1.height = Math.max(getHeight(k1.rightChild),getHeight(k1.leftChild)) + 1;
            k2.height = Math.max(getHeight(k2.rightChild),getHeight(k2.leftChild)) + 1;
            return k2;
        }else {
            Node k1 = node.rightChild;
            k2.rightChild = k1.leftChild;
            k1.leftChild = k2;
            k1.height = Math.max(getHeight(k1.rightChild),getHeight(k1.leftChild)) + 1;
            k2.height = Math.max(getHeight(k2.rightChild),getHeight(k2.leftChild)) + 1;
            return k2;
        }
    }

    // 双旋转
    private  Node doubleRotation(Node node){
        Node k3 = node;
        if (getHeight(node.leftChild) > getHeight(node.rightChild)){
            Node k1 = node.leftChild;
            Node k2 = k1.rightChild;
            k3.leftChild = k2.rightChild;
            k1.rightChild = k2.leftChild;
            k2.leftChild = k1;
            k2.rightChild = k3;
            k1.height = Math.max(k1.leftChild.height,k1.rightChild.height) + 1;
            k2.height = Math.max(k2.leftChild.height,k2.rightChild.height) + 1;
            k3.height = Math.max(k3.leftChild.height,k3.rightChild.height) + 1;
            return k2;
        }else {
            Node k1 = node.rightChild;
            Node k2 = k1.leftChild;
            k3.rightChild = k2.leftChild;
            k1.leftChild = k2.rightChild;
            k2.rightChild = k1;
            k2.leftChild = k3;
            k1.height = Math.max(k1.leftChild.height,k1.rightChild.height) + 1;
            k2.height = Math.max(k2.leftChild.height,k2.rightChild.height) + 1;
            k3.height = Math.max(k3.leftChild.height,k3.rightChild.height) + 1;
            return k2;
        }
    }

}
