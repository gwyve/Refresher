package OJ.LeetCode.Num201_250;

import java.util.List;

public class Num203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode run = pre;
        while (run != null && run.next!=null){
            if (run.next.val == val){
                run.next = run.next.next;
            }else {
                run = run.next;
            }
        }
        return pre.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}