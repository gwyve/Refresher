package OJ.LeetCode.Num051_100;

import java.util.List;

/**
 * Created by VE on 2017/8/15.
 */
public class Num092ReverseLinkedListII {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    private void print(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    private ListNode create(int[] nums){
        ListNode dummy = new ListNode(0);
        ListNode head = new ListNode(nums[0]);
        dummy.next = head;
        for (int i = 1; i < nums.length; i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (m == 1){
            return reverseFromHead(head,n-m+1);
        }else {
            for (int i = 0; i < m-2; i++) {
                head = head.next;
            }
            ListNode tmp = new ListNode(0);
            tmp.next= head;
            tmp.next.next = reverseFromHead(head.next,n-m+1);
            return dummy.next;
        }



    }
    private ListNode reverseFromHead(ListNode head,int res){
        if (res == 1)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current;
        if (head.next != null)
            current = head.next;
        else
            return head;
        ListNode tail;
        if (head.next.next != null)
            tail= head.next.next;
        else{
            head.next.next = head;
            ListNode tmp = head.next;
            head.next = null;
            return tmp;
        }


        current.next = head;
        for (int i = 2; i < res; i++) {
            head = current;
            current = tail;
            tail = tail.next;
            current.next = head;
        }
        dummy.next.next = tail;
        return current;
    }

    public static void main(String[] args){
        Num092ReverseLinkedListII obj = new Num092ReverseLinkedListII();
        ListNode head = obj.create(new int[]{1,2,3});
        obj.print(obj.reverseBetween(head, 1, 1));
    }
}
