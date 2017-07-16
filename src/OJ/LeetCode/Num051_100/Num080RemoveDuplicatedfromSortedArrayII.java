package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/15.
 */
public class Num080RemoveDuplicatedfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int n:nums){
            if (count<2 || n > nums[count-2]){
                nums[count] = n;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Num080RemoveDuplicatedfromSortedArrayII obj = new Num080RemoveDuplicatedfromSortedArrayII();
        System.out.println(obj.removeDuplicates(new int[]{1}));
    }
}
