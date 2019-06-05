package OJ.LeetCode.Num151_200;

public class Num152MaximumProductSubarray {

    public int maxProductDP(int[] nums){
        // 这个地方因为有0和负数，需要维护两个数列
        int[] minDP = new int[nums.length];
        int[] maxDP = new int[nums.length];
        if (nums==null || nums.length == 0)
            return 0;
        int res = nums[0];
        minDP[0] = nums[0];
        maxDP[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int min = minDP[i-1]*nums[i];
            int max = maxDP[i-1]*nums[i];
            maxDP[i] = max>min?max:min;
            maxDP[i] = maxDP[i]>nums[i]?maxDP[i]:nums[i];
            minDP[i] = min<max?min:max;
            minDP[i] = minDP[i]<nums[i]?minDP[i]:nums[i];
            res = res>maxDP[i]?res:maxDP[i];
        }
        return res;
    }


    public int maxProduct(int[] nums) {
        // 令人震惊，暴力求解竟然可以ac
        if (nums == null || nums.length == 0)
            return 0;
        long res = nums[0];
        if (nums.length == 1)
            return (int)res;
        for (int i = 0; i < nums.length; i++) {
            long tmp = nums[i];
            res = res>tmp?res:tmp;
            for (int j = i+1; j < nums.length; j++) {
                tmp = tmp * nums[j];
                res = res>tmp?res:tmp;
            }
        }
        return (int)res;
    }
}