package OJ.LeetCode.Num051_100;

/**
 * Created by yixina-z on 18/2/17.
 */
public class Num088MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1, cur2 = n -1;
        for (int i = m+n-1; i >= 0 ; i--) {

            if(cur1<0){
                nums1[i] = nums2[cur2];
                cur2--;
                continue;
            }
            if (cur2<0){
                nums1[i] = nums1[cur1];
                cur1--;
                continue;
            }
            if (nums1[cur1] > nums2[cur2]){
                nums1[i] = nums1[cur1];
                cur1--;
            }else {
                nums1[i] = nums2[cur2];
                cur2--;
            }
        }
    }

    public static void main(String[] args){
        Num088MergeSortedArray obj = new Num088MergeSortedArray();
        int[] num1 = new int[]{1};
        int[] num2 = new int[]{};
        obj.merge(num1,num1.length,num2,num2.length);
        System.out.println("wwwww");
    }
}
