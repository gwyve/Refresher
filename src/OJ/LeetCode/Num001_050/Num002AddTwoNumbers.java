package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/1/6.
 */
//题目位置：https://leetcode.com/problems/add-two-numbers/

public class Num002AddTwoNumbers {



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        public void show(){
            ListNode node = this;
            while(node != null){
                System.out.print(node.val + "  ");
                node = node.next;
            }
        }
    }


        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode first;
            int carryFlag = 0;
            if (l1.val + l2.val <10){
                first = new ListNode(l1.val+l2.val);
            }else{
                carryFlag = 1;
                first = new ListNode(l1.val+l2.val-10);
            }
            l1 = l1.next;
            l2 = l2.next;

            ListNode node = first;


            while((l1 != null || l2 != null) ){
                if ( l1 == null && l2 != null  ){
                    if (l2.val+carryFlag<10){
                        node.next = new ListNode(l2.val + carryFlag);
                        carryFlag = 0;
                    }else {
                        node.next = new ListNode(l2.val + carryFlag - 10);
                        carryFlag = 1;
                    }
                    l2 = l2 .next;
                }
                if ( l2 == null && l1 != null ){
                    if (l1.val+carryFlag<10){
                        node.next = new ListNode(l1.val + carryFlag);
                        carryFlag = 0;
                    }else {
                        node.next = new ListNode(l1.val + carryFlag - 10);
                        carryFlag = 1;
                    }
                    l1 = l1.next;
                }
                if(l1 != null && l2 != null){
                    if (l1.val + l2.val + carryFlag < 10){
                        node.next = new ListNode(l1.val + l2.val + carryFlag);
                        carryFlag = 0;
                    }else {
                        node.next = new ListNode(l1.val + l2.val + carryFlag -10);
                        carryFlag = 1;
                    }
                    l1 = l1.next;
                    l2 = l2.next;
                }
                node = node.next;
            }
            if (carryFlag ==1 ){
                node.next = new ListNode(carryFlag);
            }
            return first;
        }


    public static void main(String[] args){
        int[] a = new int[] {5};
        int[] b = new int[] {5};
        ListNode l1 = new ListNode(a[0]);
        ListNode l2 = new ListNode(b[0]);
        ListNode node = l1;
        for (int i = 1; i < a.length; i++) {
            node.next = new ListNode(a[i]);
            node = node.next;
        }
        node = l2;
        for (int i = 1; i < b.length; i++) {
            node.next = new ListNode(b[i]);
            node = node.next;
        }
        Num002AddTwoNumbers obj = new Num002AddTwoNumbers();
        ListNode ret = obj.addTwoNumbers(l1,l2);
        ret.show();

    }


}
