package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/23.
 */
public class Num091DecodeWays {

    public int numDecodings(String s){
//        这个就是动态规划的解决方法
        if (s == null || s.length() ==0)
            return 0;
        int len = s.length();
        int [] dp = new int[len+1];
        dp[0] = 1;
//        这是个经典的地方
        dp[1] = s.charAt(0) == '0'? 0:1;
        for (int i = 2 ; i <=len ; i++) {
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2,i));
            if (first> 0 && first<10){
                dp[i] += dp[i-1];
            }
            if (second>9 && second<27){
                dp[i] += dp[i-2];
            }

        }
        return dp[len];

    }

    public static void main(String[] args){
        Num091DecodeWays obj = new Num091DecodeWays();
        System.out.println(obj.numDecodings("0234"));
    }
}
