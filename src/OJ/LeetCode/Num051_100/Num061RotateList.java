package OJ.LeetCode.Num051_100;


/**
 * Created by VE on 2017/7/8.
 */
public class Num061RotateList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){this.val = x;}
    }


    public ListNode rotateRight(ListNode head,int k){
        if (head == null || head.next== null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        int len = 0;
        while(fast.next != null){
            fast = fast.next;
            len++;
        }

        for (int i = 0; i <len - k%len; i++) {
            slow = slow.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;

    }

    private void printListNode(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    private ListNode createListNode(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode tmp = head;
        for (int i = 1; i < nums.length; i++) {
            tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
        }
        return head;
    }

    public static void main(String[] args){
        Num061RotateList obj = new Num061RotateList();
        ListNode head = obj.createListNode(new int[]{1,2,3,4,5});

        obj.printListNode(obj.rotateRight(head,5));
    }
}
