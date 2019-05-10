package OJ.LeetCode.Num051_100;

public class Num072EditDistance {

    public int minDistance(String word1, String word2) {
        // 这个使用dp之后比较简单
        // 我只是在两个字符相同，dp[i][j] = dp[i-1][j-1] 没有相太明白
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length()+1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    int min = dp[i-1][j];
                    min = min > dp[i][j-1]? dp[i][j-1]:min;
                    min = min > dp[i-1][j-1]? dp[i-1][j-1]:min;
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args){
        Num072EditDistance obj = new Num072EditDistance();
        System.out.println(obj.minDistance("horse","ros"));

    }

}