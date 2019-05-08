package OJ.LeetCode.Num001_050;

public class Num044WildcardMatching {

    public boolean isMatch(String s, String p) {
        //这个题跟num010特别像
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        dp[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++) {
            if (dp[0][i-1] && p.charAt(i-1)=='*')
                dp[0][i] = true;
        }

        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {
                if (p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    // 这个是个重点
                    dp[i][j] = dp[i][j-1] || dp[i-1][j] || dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j-1] && p.charAt(j-1) == s.charAt(i-1);
                }

            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args){
        Num044WildcardMatching obj = new Num044WildcardMatching();
        System.out.println(obj.isMatch("aa","*"));
    }
}