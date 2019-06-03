package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.List;

public class Num148SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow;
        slow = slow.next;
        fast.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode head,ListNode mid){
        ListNode pre = new ListNode(-1);
        ListNode run = pre;
        while (head!=null || mid!=null){
            if (head == null){
                run.next = mid;
                run = run.next;
                mid = mid.next;
            }else if (mid == null){
                run.next = head;
                run = run.next;
                head = head.next;
            }else {
                if (head.val<mid.val){
                    run.next = head;
                    run = run.next;
                    head = head.next;
                }else {
                    run.next = mid;
                    run = run.next;
                    mid = mid.next;
                }
            }

        }
        return pre.next;

    }





//    public ListNode sortList(ListNode head) {
//        // 最开始考虑的堆排序，超时了
//        List<ListNode> list = new ArrayList<ListNode>();
//        while (head!=null){
//            list.add(head);
//            head = head.next;
//        }
//        ListNode pre = new ListNode(-1);
//        ListNode run = pre;
//
//        while (list.size()!=0){
//            adjust(list);
//            run.next = list.get(0);
//            list.remove(0);
//            run = run.next;
//        }
//        run.next = null;
//        return pre.next;
//
//    }
//
//    public void adjust(List<ListNode> list){
//        int last = list.size()/2 - 1;
//        for (int i = last; i >=0; i--) {
//            int min;
//            ListNode parent = list.get(i);
//            ListNode leftChild = list.get(2*i+1);
//            min = parent.val<=leftChild.val?i:2*i+1;
//            if (2*i+2 < list.size()){
//                ListNode rightChild = list.get(2*i +2);
//                min = list.get(min).val<=rightChild.val?min:2*i+2;
//            }
//            if (min!=i){
//                ListNode minNode = list.get(min);
//                ListNode tmp = list.get(i);
//                list.remove(i);
//                list.add(i,minNode);
//                list.remove(min);
//                list.add(min,tmp);
//            }
//        }
//    }

    public static void main(String[] args){
        Num148SortList obj = new Num148SortList();
        int[] nums = new int[]{4,2,1,3};
        ListNode head = new ListNode(nums[0]);
        ListNode run = head;
        for (int i = 1; i < nums.length; i++) {
            run.next = new ListNode(nums[i]);
            run = run.next;
        }
        head = obj.sortList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}