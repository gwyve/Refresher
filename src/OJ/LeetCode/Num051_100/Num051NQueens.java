package OJ.LeetCode.Num051_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by VE on 2017/6/25.
 */
public class Num051NQueens {

    public List<List<String>> solveNQueens(int n){
        List<List<String >> retList = new ArrayList<List<String>>();
        helper(n,0,retList,new ArrayList<String>(),new boolean[n],new boolean[2*n-1],new boolean[2*n-1]);
        return retList;
    }

    private void helper(int n,int r,List<List<String>> retList,List<String> strList ,boolean[] col, boolean[] d1,boolean[] d2){
//        这个方法主要是考虑到两个对角的相关规律进行的。
        if (strList.size() == n){
            retList.add(new ArrayList<String>(strList));
        }else {
            for (int c = 0; c < n; c++) {
                int dOne = r + c;
                int dTwo = r - c + n - 1;
                if (col[c] || d1[dOne] || d2[dTwo])
                    continue;
                char[] strChar = new char[n];
                Arrays.fill(strChar,'.');
                strChar[c] = 'Q';
                String str = new String(strChar);
                col[c] = true;
                d1[dOne]  = true;
                d2[dTwo] = true;
                strList.add(str);
                helper(n,r+1,retList,strList,col,d1,d2);
                strList.remove(strList.size()-1);
                col[c] = false;
                d1[dOne] = false;
                d2[dTwo] = false;
            }
        }
    }

    public static void main(String[] args){
        Num051NQueens obj = new Num051NQueens();
        System.out.println(obj.solveNQueens(4));
    }
}
