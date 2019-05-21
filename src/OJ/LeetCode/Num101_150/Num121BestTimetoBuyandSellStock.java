package OJ.LeetCode.Num101_150;

public class Num121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        // 最动脑子的方法，速度特别慢
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int ru = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                int zheng = prices[j] - ru;
                res = res>zheng?res:zheng;
            }
        }
        if (res>0)
            return res;
        else
            return 0;
    }
}