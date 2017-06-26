package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/6/26.
 */
public class Num052NQueesII {
    int count = 0;
//    这里如果不这么定义的话，就很难做成，因为java很难传值
    public int totalNQueens(int n){
//        方法还是跟之前的类似
        helper(0,n,new boolean[n],new boolean[2*n-1],new boolean[2*n-1]);
        return count;
    }

    private void helper(int r,int n,boolean[] col,boolean[] d1,boolean[] d2){
        if (r == n){
            count ++;
        }else {
            for (int c = 0; c < n; c++) {
                int dOne = r+c;
                int dTwo = r-c+n-1;
                if (col[c] || d1[dOne] || d2[dTwo])
                    continue;
                col[c] = true;
                d1[dOne] = true;
                d2[dTwo] =true;
                helper( r + 1, n, col, d1, d2);
                col[c] = false;
                d1[dOne] = false;
                d2[dTwo] = false;
            }
        }
    }

    public static void main(String[] args){
        Num052NQueesII obj = new Num052NQueesII();
        System.out.println(obj.totalNQueens(4));
    }

}
