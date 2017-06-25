package OJ.LeetCode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by VE on 2017/6/25.
 */
public class Num048RotateImage {

    public void rotate(int[][] matrix){
        if (matrix == null)
            return;
        int n = matrix.length;
        if (n == 0 || n!= matrix[0].length)
            return;
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = matrix[n-1-j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ret[i][j];
            }
        }
    }

    public static void main(String[] args){
        Num048RotateImage obj = new Num048RotateImage();
        int[][] matrix = new int[][]{{1,2,3},{1,2,3},{1,2,3}};
        obj.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
