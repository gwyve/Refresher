package SwordPointOffer;

/**
 * Created by VE on 2017/3/3.
 */
public class Num016ReverseList {

    private class ListNode{
        int value;
        ListNode next;
        ListNode(int data){
            this.value = data;
            next = null;
        }
    }

    private ListNode intToList(int[] data){
        if (data.length <=0)
            return null;
        ListNode head = new ListNode(data[0]);
        ListNode p = head;
        for (int i = 1; i < data.length; i++) {
            ListNode next = new ListNode(data[i]);
            p.next = next;
            p = next;
        }
        return head;
    }

    private void printList(ListNode head){
        while(head != null){
            System.out.print(head.value+"  ");
            head = head.next;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode cNode = head;
        ListNode reversedHead = null;
        ListNode preNode = null;
        while (cNode != null){
            ListNode nextNode = cNode.next;
            if (nextNode == null)
                reversedHead = cNode;

            cNode.next = preNode;
            preNode = cNode;
            cNode = nextNode;
        }
        return reversedHead;
    }

    public static void main(String args[]){
        Num016ReverseList obj = new Num016ReverseList();
        ListNode head = obj.intToList(new int[]{1});
        obj.printList(obj.reverse(head));
    }
}
