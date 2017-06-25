package OJ.LeetCode;


/**
 * Created by VE on 2017/1/7.
 */
//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class Num004MedianOfTwoSortedArrays {

    public double findKth(int[] A,int astart,int aend,int[] B,int bstart,int bend,int k){
        //这里如果切成子数组输入，会超时，所以引用了start和end这两个作为标记
        int m = aend - astart + 1;
        int n = bend - bstart + 1;
        if (m > n)
            return findKth(B,bstart,bend,A,astart,aend,k);
        if (m == 0)
            return B[k-1];
        if (k == 1)
            return Math.min(A[astart],B[bstart]);

        int p1 = Math.min(k/2,m);
        int p2 = k - p1;

        if (A[astart+p1-1] < B[bstart+p2-1]){
            return findKth(A,astart+p1,aend,B,bstart,bend,k-p1);
        }else if (A[astart+p1-1] > B[bstart+p2-1]){
            return findKth(A,astart,aend,B,bstart+p2,bend,k-p2);
        }else {
            return A[p1-1];
        }

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (((l1 + l2)%2)==0){
            return (findKth(nums1,0,l1-1,nums2,0,l2-1,(l1+l2)/2) + findKth(nums1,0,l1-1,nums2,0,l2-1,(l1+l2)/2 +1))/2;
        }else {
            return findKth(nums1,0,l1-1,nums2,0,l2-1,(l1+l2)/2 + 1);
        }
    }

    public static void main(String[] args){
        Num004MedianOfTwoSortedArrays obj = new Num004MedianOfTwoSortedArrays();
        System.out.print(obj.findMedianSortedArrays(new int[]{1,2},new int[]{1,2}));
    }
}
