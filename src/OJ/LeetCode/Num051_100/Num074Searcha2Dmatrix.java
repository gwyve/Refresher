package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/13.
 */
public class Num074Searcha2Dmatrix {
    public boolean searchMatrix(int[][] matrix,int target){
        if (matrix == null)
            return false;
        int m = matrix.length;
        if (m == 0 || matrix[0] == null)
            return false;
        int n = matrix[0].length;
        if (n==0)
            return false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] <=target && i+1<m && matrix[i+1][0] >= target){
                for (int j = 0; j < n; j++) {
                    System.out.println(matrix[i][j]);
                    if (matrix[i][j] == target)
                        return true;
                }
            }else if (i+1 == m){
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == target)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Num074Searcha2Dmatrix obj = new Num074Searcha2Dmatrix();
        System.out.println(obj.searchMatrix(new int[][]{{1},{3}},1));
    }
}
