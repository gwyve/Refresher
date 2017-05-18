package OJ.LeetCode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by VE on 2017/5/12.
 */
public class Num023MergeKSortedLists {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    private ListNode mergeTwoList(ListNode l1,ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode ret;
        if (l1.val > l2.val){
            ret = l2;
            ret.next = mergeTwoList(l1,l2.next);
        }else {
            ret = l1;
            ret.next = mergeTwoList(l1.next,l2);
        }
        return ret;
    }


//    使用归并的想法来做这个事儿
    public ListNode mergeKLists(ListNode[] lists){
        if (lists.length<1)
            return null;
        if (lists.length == 1)
            return lists[0];
        while (lists.length > 1){
            if (lists.length % 2 ==1){
                ListNode[] tmp = new ListNode[lists.length/2 + 1];
                for (int i = 0; 2 * i < lists.length-1; i++) { //这里忘了减去这个1导致不能用
                    tmp[i] = mergeTwoList(lists[2*i],lists[2*i+1]);
                }
                tmp[lists.length/2] = lists[lists.length-1];
                lists = tmp;
            }else {
                ListNode[] tmp = new ListNode[lists.length/2];
                for (int i = 0; 2*i < lists.length; i++) {
                    tmp[i] = mergeTwoList(lists[2*i],lists[2*i +1]);
                }
                lists = tmp;
            }
        }
        return lists[0];
    }

    private ListNode[] createList(int[][] nums){
        ListNode[] lists = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ListNode head = lists[i];
            for (int j = 0; j < nums[i].length; j++) {
                head = new ListNode(nums[i][j]);
                head = head.next;
            }
        }
        return lists;
    }

    public static void main(String[] args){
        ListNode[] a = new ListNode[3];
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        Num023MergeKSortedLists obj = new Num023MergeKSortedLists();
        a[2] = obj.mergeTwoList(a1,a2);

        System.out.println(a[2].next.val);
    }



}
