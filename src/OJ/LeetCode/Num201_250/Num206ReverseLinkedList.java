package OJ.LeetCode.Num201_250;

import java.util.List;

public class Num206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode pre = new ListNode(-1);
        while (head != null){
            ListNode headNext = head.next;
            head.next = pre.next;
            pre.next = head;
            head = headNext;
        }
        return pre.next;
    }

    public static void main(String[] args){
        int[] tmp = new int[]{1,2,3,4,5,6};
        ListNode pre = new ListNode(-1);
        ListNode run = pre;
        for (int i = 0; i < tmp.length; i++) {
            run.next = new ListNode(tmp[i]);
            run = run.next;
        }
        Num206ReverseLinkedList obj =new Num206ReverseLinkedList();
        run = obj.reverseList(pre.next);
        while (run!=null){
            System.out.print(run.val);
            run = run.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}