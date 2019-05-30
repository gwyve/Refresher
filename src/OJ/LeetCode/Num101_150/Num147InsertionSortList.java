package OJ.LeetCode.Num101_150;

public class Num147InsertionSortList {
    ListNode tail;
    public ListNode insertionSortList(ListNode head) {
        // 这种题需要先设置一个head 的pre 的，竟然忘记了
        ListNode pre = new ListNode(-1);
        while (head!=null){
            ListNode next = head.next;
            sort(pre,head);
            head = next;
        }
        return pre.next;
    }
    public void sort(ListNode pre,ListNode cur){
        if (pre.next == null){
            pre.next = cur;
            cur.next = null;
            return;
        }
        // 这种小于等于的情况，竟然忘记了
        if (cur.val<=pre.next.val){
            cur.next = pre.next;
            pre.next = cur;
            return;
        }
        ListNode run = pre.next;
        while (run.next!=null){
            // 这里需要处理等于的情况
            if (run.val<cur.val && run.next.val>=cur.val){
                cur.next = run.next;
                run.next = cur;
                return;
            }
            run = run.next;
        }
        run.next = cur;
        cur.next = null;

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
        Num147InsertionSortList obj = new Num147InsertionSortList();
        int[] nums = new int[]{4,19,14,5,-3,1,8,5,11,15,-3};
        ListNode head = new ListNode(nums[0]);
        ListNode run = head;
        for (int i = 1; i < nums.length; i++) {
            run.next = new ListNode(nums[i]);
            run = run.next;
        }
        head = obj.insertionSortList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}