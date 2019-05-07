package OJ.LeetCode.Num001_050;

public class Num010RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        //  如果是* 则需要看两步之前的匹配情况

        if (s == null || p == null)
            return false;

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        // 一下两个循环基本没用
        for (int i = 0; i < s.length()+1; i++) {
            dp[i][0] = false;
        }
        for (int i = 0; i < p.length()+1; i++) {
            dp[0][i] = false;
        }
        dp[0][0] = true;

        // 这一步很容易忘掉
        for (int i = 1; i < p.length()+1; i++) {
            if (p.charAt(i-1) =='*' && dp[0][i-2])
                dp[0][i] = true;
        }


        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {
                if (p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                if (p.charAt(j-1) == '*'){
                    if (s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2)!='.'){
                        dp[i][j] = dp[i][j-2];
                    }else {
                        // dp[i][j-2] 表示*一个都不匹配
                        // dp[i][j-1] 表示*匹配一个
                        // dp[i][j+1] 表示*匹配多个
                        dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                    }
                }
            }
        }


        return dp[s.length()][p.length()];

    }


    public static void main(String[] args){
        Num010RegularExpressionMatching obj = new Num010RegularExpressionMatching();
        System.out.println(obj.isMatch("aab","c*a*b"));
    }
}