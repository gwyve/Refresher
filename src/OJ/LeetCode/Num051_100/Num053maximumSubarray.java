package OJ.LeetCode.Num051_100;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by VE on 2017/6/26.
 */
public class Num053maximumSubarray {

    public int maxSubArray1(int[] nums){
//      这是一个n的平方的算法
//      这个算法超时了
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int thisSub = 0;
            for (int j = i; j < nums.length; j++) {
                thisSub += nums[j];
                if (max<thisSub)
                    max = thisSub;
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums){
//        这个方法只是n的复杂度
//        这个方法在于第一个subarray需要正数，如果不是正数的话，必须之前的和大于这个的绝对值。
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max)
                max = sum;

            if (sum<=0)
                sum = 0;
        }
        return max;
    }

    public static void main(String[] args){
        Num053maximumSubarray obj = new Num053maximumSubarray();
        System.out.println(obj.maxSubArray2(new int[]{-3,-2,0,-1}));
    }

}
