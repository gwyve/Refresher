package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/5/18.
 */
public class Num025ReverseNodesInKGroup {
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

    public ListNode reverseKGroup(ListNode head,int k){
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode tail = dummy;
        ListNode tmp;
        int count;
        while (true){
            count = k;
            while (count > 0 && tail != null){
                count--;
                tail = tail.next;
            }
            if (tail == null)
                break;

            head = prev.next;
            while (prev.next != tail){
                tmp = prev.next;
                prev.next = tmp.next;

                tmp.next = tail.next;
                tail.next = tmp;
            }

            tail = head;
            prev = head;

        }

        return dummy.next;


    }


    public static  void main(String[] args){
        Num025ReverseNodesInKGroup obj = new Num025ReverseNodesInKGroup();
        ListNode list = obj.createList(new int[]{1,2,3,4,5,6,7,8,9});
        obj.printList(obj.reverseKGroup(list,2));
    }
}
