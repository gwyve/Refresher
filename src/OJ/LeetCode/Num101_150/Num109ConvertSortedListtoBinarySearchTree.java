package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.List;

public class Num109ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST1(ListNode head){
        // 快慢指针，在listnode快慢指针的用法

        if (head == null)
            return null;
        return helper2(head,null);
    }

    public TreeNode helper2(ListNode head,ListNode tail){
        if(head == tail)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast!=tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode res = new TreeNode(slow.val);
        res.left = helper2(head,slow);
        res.right = helper2(slow.next,tail);
        return res;
    }


    public TreeNode sortedListToBST(ListNode head) {
        // 这个是参考108然后写出来的
        List<Integer> list = new ArrayList<Integer>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        if (list.size()==0)
            return null;
        return helper(list,0,list.size()-1);
    }

    public TreeNode helper(List<Integer> nums,int low,int high){
        if (low>high)
            return null;
        if (low == high)
            return new TreeNode(nums.get(low));
        int mid = (low+high)/2;
        TreeNode res = new TreeNode(nums.get(mid));
        res.left = helper(nums,low,mid-1);
        res.right = helper(nums,mid+1,high);
        return res;
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}