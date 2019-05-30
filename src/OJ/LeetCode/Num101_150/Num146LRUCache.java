package OJ.LeetCode.Num101_150;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Num146LRUCache {

    private class Node{
        Node pre;
        Node next;
        int val;
        int key;
        Node(int key,int val,Node pre,Node next){
            this.pre = pre;
            this.next = next;
            this.val = val;
            this.key = key;
        }
    }

    int capacity;
    int curSize;
    Node head;
    Node tail;
    HashMap<Integer,Node> map;

    public Num146LRUCache(int capacity) {
        // 双向链表，hashmap作为开头查找很有效
        // -1 是开头
        // -2 是尾巴
        head = new Node(-1,-1,null,null);
        tail = new Node(-2,-2,null,null);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<Integer, Node>();
        this.capacity = capacity+2;
        curSize = 2;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node cur = map.get(key);

            detachNode(cur);
            insertToHead(cur);

            return cur.val;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node cur = map.get(key);
            cur.val = value;

            detachNode(cur);
            insertToHead(cur);

        }else {
            Node cur = new Node(key,value,null,null);

            insertToHead(cur);

            map.put(key,cur);
            curSize++;

            if (curSize>capacity){
                Node del = tail.pre;
                detachNode(del);

                map.remove(del.key);
                curSize--;
            }
        }
    }
    public void insertToHead(Node cur){
        cur.next = head.next;
        cur.pre = head;
        head.next.pre = cur;
        head.next = cur;
    }

    public void detachNode(Node cur){
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }

    public static void main(String[] args){
        Num146LRUCache obj = new Num146LRUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        obj.get(1);
        obj.put(3,3);
        obj.get(2);
        obj.put(4,4);
        obj.get(1);
        System.out.println(obj.get(3));
        obj.get(4);
    }
}