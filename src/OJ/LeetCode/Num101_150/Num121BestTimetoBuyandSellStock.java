package OJ.LeetCode.Num101_150;

public class Num121BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        // 最动脑子的方法，速度特别慢
        // 这个是需要扫面两边的n平方级别的
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
    public int maxProfit1(int[] prices){
        // 因为卖出一定是在买入之后，所以只用扫描一遍就好
        if (prices==null || prices.length==0)
            return 0;
        int buy = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy = buy<prices[i]?buy:prices[i];
            res = res>(prices[i]-buy)?res:prices[i]-buy;
        }
        return res;
    }

}