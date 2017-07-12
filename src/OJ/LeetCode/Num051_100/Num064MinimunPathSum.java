package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/12.
 */
public class Num064MinimunPathSum {
    public int minpathSum(int[][] grid){
        if (grid == null)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i-1][j]< grid[i][j-1])
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                else
                    grid[i][j] = grid[i][j-1] + grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}
