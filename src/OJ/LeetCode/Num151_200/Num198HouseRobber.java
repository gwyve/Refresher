package OJ.LeetCode.Num151_200;

public class Num198HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        if (n == 1)
            return nums[0];
        dp[0] = nums[0];
        dp[1] = nums[1];
        if (n == 2)
            return dp[0]>dp[1]?dp[0]:dp[1];
        dp[2] = dp[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            int tmp = dp[i-3] + nums[i];
            tmp = (dp[i-2] + nums[i])>tmp?(dp[i-2] + nums[i]):tmp;
            dp[i] = tmp>dp[i-1]?tmp:dp[i-1];
        }
        return dp[n-1]>dp[n-2]?dp[n-1]:dp[n-2];
    }


    public static void main(String[] args){
        Num198HouseRobber obj = new Num198HouseRobber();
        System.out.println(obj.rob(new int[]{2,1,1,2}));
    }
}