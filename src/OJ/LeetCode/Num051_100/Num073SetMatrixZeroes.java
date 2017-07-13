package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/13.
 */
public class Num073SetMatrixZeroes {
    public void setZeroes(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] a = new int[m];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    a[i] = 1;
                    b[j] =1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (a[i] == 1)
                for (int j = 0; j < n; j++) {
                    matrix[i][j] =0;
                }
        }
        for (int i = 0; i < n; i++) {
            if (b[i] == 1)
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
        }
    }

}
