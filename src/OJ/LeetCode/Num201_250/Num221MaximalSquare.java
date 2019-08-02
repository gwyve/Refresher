package OJ.LeetCode.Num201_250;

public class Num221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // 这个方法，需要仔细想想的
        // https://blog.csdn.net/u012501459/article/details/46553139 解法二
        if (matrix == null || matrix.length<1 || matrix[0].length<1)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int ret = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    dp[i][j] = 1;
                    if (i>0 && j>0){
                        dp[i][j]+= Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                    }
                    ret = Math.max(ret,dp[i][j]);
                }
            }
        }
        return ret*ret;
    }
}