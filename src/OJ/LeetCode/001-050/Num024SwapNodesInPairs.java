package OJ.LeetCode;

/**
 * Created by VE on 2017/5/18.
 */
public class Num024SwapNodesInPairs {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
    private ListNode createList(int[] nums){
        if (nums== null || nums.length<1)
            return null;
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }
    private void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


    public ListNode swapPairs(ListNode head){
        // 先指定具体位置
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null){
            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        Num024SwapNodesInPairs obj = new Num024SwapNodesInPairs();
        ListNode list = obj.createList(new int[]{1,2});
        list = obj.swapPairs(list);
        obj.printList(list);
    }
}
