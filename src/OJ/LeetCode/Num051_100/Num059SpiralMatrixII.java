package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/4.
 */
public class Num059SpiralMatrixII {

    public int[][] generatreMatrix(int n){
        int[][] ret = new int[n][n];
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        int count = 0;
        while (left <= right){
            for (int i = left; i <= right ; i++) {
                ret[top][i] = count++;
            }
            top++;
            for (int i = top; i <= down ; i++) {
                ret[i][right] = count++;
            }
            right--;
            for (int i = right; i >= left ; i--) {
                ret[down][i] = count++;
            }
            down--;
            for (int i = down; i >= top ; i--) {
                ret[i][left] = count++;
            }
            left++;
        }
        return ret;
    }


}
