package OJ.LeetCode.Num101_150;

public class Num122BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        // 这个题的想法是分成了多个121的做法
        // 需要注意最后一个元素的时候情况
        int buy = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (profit < (prices[i] - buy)){
                profit = prices[i] -buy;
            }else if(profit>0){
                res += profit;
                buy = Integer.MAX_VALUE;
                profit = Integer.MIN_VALUE;
            }
            if (prices[i] < buy)
                buy = prices[i];
        }
        if (profit>0)
            res+=profit;
        return res;
    }

    public static void main(String[] args){
        Num122BestTimetoBuyandSellStockII obj = new Num122BestTimetoBuyandSellStockII();
        System.out.println(obj.maxProfit(new int[]{2,1,2,1,0,0,1}));
    }
}