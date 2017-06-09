package OJ.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VE on 2017/6/9.
 */
public class Num036ValidSudoku {
    public boolean isValidSudoku(char[][] board){
//        这个方法就是solution的想法，复杂度也很高
//        '4' in row 7 is encoded as "(4)7".
//        '4' in column 7 is encoded as "7(4)".
//        '4' in the top-right block is encoded as "0(4)2".
        Set set = new HashSet<String>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.'){
                    String num = "("+board[i][j]+")";
                    if (!set.add(num + i) || ! set.add(j + num) || ! set.add(i/3 + num + j/3))
                        return false;
                }
            }
        }
        return true;


    }
}
