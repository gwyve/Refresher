package SwordPointOffer;

/**
 * Created by VE on 2017/3/9.
 */
public class Num017MergeList {
    class ListNode{
        int value;
        ListNode next;
        ListNode(int data){
            this.value = data;
            next = null;
        }
    }

    public ListNode intToList(int[] data){
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

    public void printList(ListNode head){
        while(head != null){
            System.out.print(head.value+"  ");
            head = head.next;
        }
    }

    public ListNode merge(ListNode list1,ListNode list2){
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode pHead = null;
        if (list1.value < list2.value){
            pHead = list1;
            pHead.next = merge(list1.next,list2);
        }else {
            pHead = list2;
            pHead.next = merge(list1,list2.next);
        }
        return pHead;
    }


    public static  void main(String args[]){
        Num017MergeList obj = new Num017MergeList();
        ListNode l1 = obj.intToList(new int[]{1,3,5,7,9});
        ListNode l2 = obj.intToList(new int[]{2,3,4,6,7,8});

        obj.printList(obj.merge(l1,l2));
    }

}
