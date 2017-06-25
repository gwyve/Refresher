package OJ.LeetCode.Num001_050;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/4/2.
 */
public class Num0184Sum {
    public List<List<Integer>> fourSum(int[] nums,int target){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;
        Arrays.sort(nums);

        int max = nums[len-1];
        if (max *4 < target || nums[0] * 4 > target)
            return res;

        for (int i = 0; i < len; i++) {
            int z = nums[i];
            if (i>0 && nums[i] == nums[i-1])
                continue;
            if (z + max *3 <target)
                continue;
            if (z + nums[0] *3 > target)
                continue;
            if (z * 4 == target){
                if (i+3<len && nums[i+3] == z)
                    res.add(Arrays.asList(z,z,z,z));
                continue;
            }
            threeSum(nums,target-z,i+1,len-1,res,z);
        }
        return res;
    }

    private void threeSum(int[] nums,int target,int low,int high,List<List<Integer>>res,int z1){

        if (low + 2 > high)
            return;

        int max = nums[high];
        if (max * 3 <target || nums[low] *3 >target)
            return;

        for (int i = low; i <=  high; i++) {
            int z = nums[i];
            if (i>low && nums[i] == nums[i-1])
                continue;
            if (z + 2*max < target)
                continue;
            if (z + 2* nums[low] >target)
                continue;
            if (z *3 == target){
                if (i+2 <= high && nums[i] == nums[i+2])
                    res.add(Arrays.asList(z1,z,z,z));
                continue;
            }
            twoSum(nums,target-z,i+1,high,res,z1,z);

        }
    }

    private void twoSum(int[] nums,int target,int low,int high,List<List<Integer>>res,int z1,int z2){

        if (low >= high)
            return;
        int max = nums[high];
        if (nums[low] *2 > target || max*2 <target)
            return;

        int i = low,j = high,x;
        while (i<j){
            if (nums[i] + nums[j] == target){
                res.add(Arrays.asList(z1,z2,nums[i],nums[j]));
                x = nums[i];
                while(++i<j&& nums[i] == x)
                    ;
                x = nums[j];
                while(i<--j && nums[j] ==x)
                    ;

            }
            if (nums[i] + nums[j] < target)
                i++;
            if (nums[i] + nums[j] >target)
                j--;
        }
    }



    public static void main(String[] args){
        Num0184Sum obj = new Num0184Sum();
        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        System.out.printf("%s",obj.fourSum(nums,-11).toString());
    }
}
