package OJ.LeetCode;

/**
 * Created by Administrator on 2017/4/2.
 */
public class Num019RemoveNthNodeFromEndofList {

    private class  ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    private ListNode createList(int[] nums){
        ListNode res = new ListNode(nums[0]);
        ListNode current = res;
        for (int i =1;i <nums.length;i++){
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return res;
    }
    private  void printList(ListNode current){
        while (current != null){
            System.out.print(current.val+" ");
            current = current.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head,int n){
        //这个里面添加这个 start真是太奇妙了
        ListNode start = new ListNode(0);
        ListNode fast = start, slow = start;
        start.next = head;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;

    }

    public static void main(String[] args){

        Num019RemoveNthNodeFromEndofList obj = new Num019RemoveNthNodeFromEndofList();
        int[] nums = new int[]{1, 2,3,4};
        obj.printList(obj.removeNthFromEnd(obj.createList(nums),2));

    }
}
