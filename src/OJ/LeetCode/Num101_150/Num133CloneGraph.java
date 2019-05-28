package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Num133CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node,Node> hashMap = new HashMap<Node, Node>();
        return DFS(node,hashMap);

    }

    public Node DFS(Node root, HashMap<Node,Node> map){
        if (root == null)
            return null;
        if (map.containsKey(root)){
            return map.get(root);
        }

        if (root.neighbors == null){
            return new Node(root.val,null);
        }

        // 在这个位置卡了一下，需要提前把node放入map中
        List<Node> neighbors = new ArrayList<Node>();
        Node copy = new Node(root.val,neighbors);
        map.put(root,copy);
        for (int i = 0; i < root.neighbors.size(); i++) {
            neighbors.add(DFS(root.neighbors.get(i),map));
        }

        return copy;
    }

    public static void main(String[] args){
        Num133CloneGraph obj = new Num133CloneGraph();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        List<Node> list1 = new ArrayList<Node>();
        list1.add(node2);
        list1.add(node4);;
        node1.val = 1;
        node1.neighbors = list1;

        List<Node> list2 = new ArrayList<Node>();
        list2.add(node1);
        list2.add(node3);
        node2.val = 2;
        node2.neighbors = list2;

        List<Node> list3 = new ArrayList<Node>();
        list3.add(node2);
        list3.add(node4);
        node3.val = 3;
        node3.neighbors = list3;

        List<Node> list4 = new ArrayList<Node>();
        list4.add(node1);
        list4.add(node3);
        node4.val = 4;
        node4.neighbors = list4;
        obj.cloneGraph(node1);
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }

}