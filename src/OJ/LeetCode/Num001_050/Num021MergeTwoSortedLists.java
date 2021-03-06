package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/4/5.
 */
public class Num021MergeTwoSortedLists {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode ret;
        if (l1.val < l2.val){
            ret = l1;
            ret.next = mergeTwoLists(l1.next,l2);
        }
        else{
            ret = l2;
            ret.next = mergeTwoLists(l1,l2.next);
        }
        return  ret;
    }
}
