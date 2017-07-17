package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/17.
 */
public class Num086PartitionList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode partition(ListNode head,int x){
        ListNode leftListdummy = new ListNode(0);
        ListNode rightListdummy = new ListNode(0);

        ListNode leftCur = leftListdummy;
        ListNode rightCur = rightListdummy;

        while (head != null){
            if (head.val < x){
                leftCur.next = head;
                leftCur = leftCur.next;
            }else {
                rightCur.next = head;
                rightCur = rightCur.next;
            }
            head = head.next;
        }
        leftCur.next = rightListdummy.next;
        rightCur.next = null;

        return leftListdummy.next;
    }

    public static void main(String[] args){
        Num086PartitionList obj = new Num086PartitionList();
        ListNode head = obj.createList(new int[]{1});
        obj.print(obj.partition(head,0));
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
}
