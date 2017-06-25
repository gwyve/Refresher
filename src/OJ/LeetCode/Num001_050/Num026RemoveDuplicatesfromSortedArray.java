package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/5/19.
 */
public class Num026RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums){
        if (nums == null || nums.length==0)
            return 0;
        int ret = 0;
        for (int n:nums){
            if (ret == 0|| n>nums[ret-1]){
                nums[ret++] = n;
            }
        }
        return ret;
    }

    public static  void main(String[] args){
        Num026RemoveDuplicatesfromSortedArray obj = new Num026RemoveDuplicatesfromSortedArray();
        System.out.println(obj.removeDuplicates(new int[]{1,1,2}));
    }
}
