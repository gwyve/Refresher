package OJ.LeetCode;

import java.util.Arrays;

/**
 * Created by VE on 2017/2/10.
 */
public class Num0163SumClosest {

    //跟015的做法很一致
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int ret = nums[0] + nums[1] + nums[nums.length-1];

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target){
                    k --;
                }else{
                    j ++;
                }
                if (Math.abs(sum -target) < Math.abs( ret - target)){
                    ret = sum;
                }
            }
        }
        return ret;

    }

    public static void main(String args[]){
        Num0163SumClosest obj = new Num0163SumClosest();
        System.out.println(obj.threeSumClosest(new int[]{0,2,1,-3},1));
    }


}
