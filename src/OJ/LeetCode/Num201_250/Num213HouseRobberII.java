package OJ.LeetCode.Num201_250;

public class Num213HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return nums[0]>nums[1]?nums[0]:nums[1];
        int a = helper(nums,0,nums.length-2);
        int b = helper(nums,1,nums.length-1);
        return a>b?a:b;
    }
    public int helper(int[] nums,int begin,int end){
        if (begin == end)
            return nums[begin];
        if (begin+1 == end)
            return nums[begin]>nums[end]?nums[begin]:nums[end];
        if (begin+2 == end)
            return (nums[begin] + nums[end])> nums[begin+1]?(nums[begin]+nums[end]):nums[begin+1];

        int[] dp = new int[nums.length];
        dp[begin] = nums[begin];
        dp[begin+1] = nums[begin+1];
        dp[begin+2] = nums[begin] + nums[begin+2];
        for (int i = begin+3; i <= end ; i++) {
            int tmp = dp[i-3] + nums[i];
            tmp = tmp>(dp[i-2] + nums[i])?tmp:(dp[i-2]+nums[i]);
            dp[i] = tmp>dp[i-1]?tmp:dp[i-1];
        }
        return dp[end];
    }

    public static void main(String[] args){
        Num213HouseRobberII obj = new Num213HouseRobberII();
        System.out.println(obj.rob(new int[]{2,7,9,3,1}));
    }
}