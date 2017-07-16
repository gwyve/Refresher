package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/16.
 */
public class Num082RemoveDuplicatesFromSortedListII {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head){
//        这个主要就是设置一个pre
        if (head == null)
            return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null){
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if (pre.next == cur){
                cur = cur.next;
                pre = pre.next;
            }else {
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head){
//        这个是看别人做的一个递推法
        if(head == null)
            return null;

        if (head.next != null && head.val == head.next.val){
            while (head.next!=null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }


    private void print(ListNode node){
        while (node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
    private ListNode createList(int[] nums){
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        for (int i = 0; i < nums.length; i++) {
            tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        Num082RemoveDuplicatesFromSortedListII obj = new Num082RemoveDuplicatesFromSortedListII();
        ListNode head = obj.createList(new int[]{1,1});
        obj.print(obj.deleteDuplicates(head));
    }

}
