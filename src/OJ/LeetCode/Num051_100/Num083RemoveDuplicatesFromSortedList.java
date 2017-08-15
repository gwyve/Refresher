package OJ.LeetCode.Num051_100;

import java.util.List;

/**
 * Created by VE on 2017/8/14.
 */
public class Num083RemoveDuplicatesFromSortedList {
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


    public ListNode deleteDuplicates(ListNode head){
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        while (head.next !=null && head.val == head.next.val){
            head = head.next;
        }
        dummy.next = head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        while (head != null){
            while (head.next != null && head.val == head.next.val){
                head = head.next;
            }
            tmp.next = head;
            tmp = tmp.next;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        Num083RemoveDuplicatesFromSortedList obj = new Num083RemoveDuplicatesFromSortedList();
        ListNode head = obj.create(new int[]{1,1,1,1,1,1,2,2,2,2,2,2,3,3});
        obj.print(obj.deleteDuplicates(head));
    }

}
