package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.List;

public class Num143ReorderList {
    public void reorderList(ListNode head) {
        // 特别笨的方法，只是可以ac罢了
        if(head == null || head.next == null || head.next.next == null)
            return;
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode run = head;
        while (run != null){
            list.add(run);
            run = run.next;
        }
        run = head;
        int index = list.size()-1;
        for (int i = 0; i < list.size(); i+=2) {
            ListNode tmp = run.next;
            run.next = list.get(index);
            index--;
            run.next.next = tmp;
            run = tmp;
        }
        if (list.size()%2!=0){
            run.next = list.get(list.size()/2);
            run = run.next;
        }
        run.next = null;

    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args){
        Num143ReorderList obj = new Num143ReorderList();
        int[] nums = new int[]{1,2};
        ListNode head = new ListNode(nums[0]);
        ListNode run = head;
        for (int i = 1; i < nums.length; i++) {
            run.next = new ListNode(nums[i]);
            run = run.next;
        }
        obj.reorderList(head);
        while (head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}