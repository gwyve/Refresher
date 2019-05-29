package OJ.LeetCode.Num101_150;

import java.util.List;

public class Num141LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head==null || head.next == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            if (fast == slow)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }



    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}