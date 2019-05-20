package OJ.LeetCode.Num101_150;

public class Num115DistinctSubsequences {
    public int numDistinct(String s, String t) {
        // 还是dp的方法，这个的具体道理我还是没有想明白，不过可以AC
        int[][] dp = new int[t.length()+1][s.length()+1];
        for (int i = 0; i < t.length()+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < s.length()+1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < t.length()+1; i++) {
            for (int j = 1; j < s.length()+1; j++) {
                if (t.charAt(i-1)== s.charAt(j-1)){
                    // 这个递推公式，我也没有想出为啥，主要是观察
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }


        return dp[t.length()][s.length()];
    }
    public static void main(String[] args){
        Num115DistinctSubsequences obj = new Num115DistinctSubsequences();
        System.out.println(obj.numDistinct("rabbbbit","rabbit"));
    }

}