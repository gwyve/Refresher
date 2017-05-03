package DataStruct.tree;

/**
 * Created by VE on 2017/5/3.
 */
public class BinarySearchTree {

    private class Node{
        int value;
        Node leftChild;
        Node rightChild;
        Node(int x){
            this.value = x;
        }
    }

    private Node findMin(Node node){
        if (node.leftChild == null)
            return node;
        else
            return findMin(node.leftChild);
    }

    private Node findMax(Node node){
        if (node.rightChild == null)
            return node;
        else
            return findMax(node.rightChild);
    }

    // 确定一个树里面是否包含一个数
    private boolean contains(int x, Node node){
        if (node == null)
            return false;
        if (x == node.value)
            return true;
        if (x < node.value)
            return contains(x,node.leftChild);
        else
            return contains(x,node.rightChild);
    }

    // 插入一个数
    private void insert(int x,Node node){
        if (node == null){
            node = new Node(x);
        }
        else if (x < node.value)
            insert(x,node.leftChild);
        else if (x > node.value)
            insert(x,node.rightChild);
    }

    // 删除某个点，这个删除个c区别还是有的
    private void remove(int x,Node node){
        if (node == null){
            return;
        }
        if (x < node.value) {
            remove(x, node.leftChild);
            return;
        }else if (x > node.value){
            remove(x,node.rightChild);
            return;
        }else{
            if (node.rightChild != null && node.leftChild != null){
                node.value = findMin(node.rightChild).value;
                remove(findMin(node.rightChild).value,node.rightChild);
            }else {
                // 这个想法很好
                node = (node.leftChild != null)? node.leftChild:node.rightChild;
            }
        }

    }
}
