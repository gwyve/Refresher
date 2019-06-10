package OJ.LeetCode.Num151_200;

import java.util.HashSet;
import java.util.Set;

public class Num160IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 用hashset标志的方法，简单想到，速度一般
        Set<ListNode> set = new HashSet<ListNode>();
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }
        while (headB!=null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return headB;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}