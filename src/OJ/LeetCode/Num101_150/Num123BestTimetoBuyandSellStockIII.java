package OJ.LeetCode.Num101_150;

public class Num123BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        // 这个方法速度，真的慢的很
        int res = 0;
        if (prices==null|| prices.length==0)
            return res;
        int[] dp = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0){
                int tmp = helper(prices,0,prices.length-1);
                res = res>tmp?res:tmp;
            }else if (i != prices.length-1){
                int a = helper(prices,0,i) + helper(prices, i+1,prices.length-1);
                res = res>a?res:a;
            }
        }
        return res;
    }
    public int helper(int[] prices,int low,int high){
        int[] dp = new int[prices.length];
        int min = prices[low];
        for (int i = low+1; i <= high; i++) {
            int cha = prices[i] - min;
            dp[i] = cha>dp[i-1]?cha:dp[i-1];
            min = min<prices[i]?min:prices[i];
        }
        return dp[high];
    }

    public static void main(String[] args){
        Num123BestTimetoBuyandSellStockIII obj = new Num123BestTimetoBuyandSellStockIII();
        System.out.println(obj.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}