package OJ.LeetCode.Num101_150;

import java.util.LinkedList;
import java.util.Queue;

public class Num117PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        if(root == null)
            return null;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tmp = queue.poll();
                if (i<size-1){
                    tmp.next = queue.peek();
                }else {
                    tmp.next = null;
                }
                if (tmp.left !=null){
                    queue.add(tmp.left);
                }
                if (tmp.right != null){
                    queue.add(tmp.right);
                }
            }
        }
        return root;

    }


    private class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(){}

        public Node(int val,Node left,Node right,Node next){
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}