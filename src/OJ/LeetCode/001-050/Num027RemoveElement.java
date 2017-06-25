package OJ.LeetCode;

/**
 * Created by VE on 2017/5/19.
 */
public class Num027RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length ==0)
            return 0;
        int dup = 0;
        for (int n:nums){
            if (n != val){
                nums[dup++] = n;
                System.out.print(n+" ");
            }
        }
        return dup;
    }

}
