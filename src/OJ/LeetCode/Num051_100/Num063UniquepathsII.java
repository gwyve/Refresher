package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/12.
 */
public class Num063UniquepathsII {
    public int uniquepathsWithObstacles(int[][] obstacleGrid){
        if (obstacleGrid == null)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] tmp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            else
                tmp[i][0] = 1;
        }


        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            else
                tmp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j =1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    tmp[i][j] = 0;
                else
                    tmp[i][j] = tmp[i-1][j] + tmp[i][j-1];
            }
        }

        return tmp[m-1][n-1];
    }

    private void print(int[][] maxtrix){
        int m = maxtrix.length;
        int n = maxtrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(maxtrix[i][j]+" ");
            }
            System.out.println();

        }
    }


    public static void main(String[] args){
        Num063UniquepathsII obj = new Num063UniquepathsII();
        System.out.println(obj.uniquepathsWithObstacles(new int[][]{{0}}));
    }
}
