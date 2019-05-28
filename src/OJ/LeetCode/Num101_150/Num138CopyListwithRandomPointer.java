package OJ.LeetCode.Num101_150;

import java.util.HashMap;

public class Num138CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<Node, Node>();
        Node res = doNext(head,map);

        Node run = res;
        while (run!=null){
            run.random = map.get(head.random);
            run = run.next;
            head = head.next;
        }
        return res;

    }

    public Node doNext(Node root, HashMap<Node,Node> map){
        if (root == null)
            return null;
        Node tmp = new Node();
        map.put(root,tmp);
        tmp.val = root.val;
        tmp.next = doNext(root.next,map);
        return tmp;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}