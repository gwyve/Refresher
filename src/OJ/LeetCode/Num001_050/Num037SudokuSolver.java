package OJ.LeetCode.Num001_050;

import java.util.HashSet;
import java.util.Set;

public class Num037SudokuSolver {

    // 这个题主要是在迭代的时候容易忘记如何做
    // 记住两种情况下的迭代

    public void solveSudoku(char[][] board) {

        solver(board,0);

    }

    public boolean solver(char[][] board,int position){
        if (position==81)
            return true;

        int row = position/9;
        int col = position%9;

        if (board[col][row] == '.'){
            for (int i = 1; i <=9 ; i++) {
                board[col][row] = (char)(i + '0');
                if (isValid(board)){
                    // 这个地方也是迭代
                    if (solver(board,position+1)){
                        return true;
                    }
                }

                // 这一步是关键，主要是担心这一步忘记
                // 如果到达该步的时候，不成立，则需要把已经输入去掉
                board[col][row] = '.';

            }
        }else {
            // 这个地方需要加一进行迭代
            if (solver(board,position+1))
                return true;
        }

        return false;
    }


    public boolean isValid(char[][] board){
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



    public static void main(String[] args){
        Num037SudokuSolver obj = new Num037SudokuSolver();
        char[][] aaa = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        obj.solveSudoku(aaa);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(aaa[j][i] + " ");
            }
            System.out.println();
        }
    }
}