package OJ.LeetCode.Num101_150;

import org.omg.CORBA.OBJ_ADAPTER;

public class Num130SurroundedRegions {

    public void solve1(char[][] board){

    }





    public void solve(char[][] board) {
        // 这个是用的深度优先搜索的结果
        if (board==null || board.length==0 || board[0].length==0)
            return;

        for (int i = 0; i < board.length; i++) {
            solveDFS(board,i,0);
            solveDFS(board,i,board[0].length-1);
        }
        for (int i = 0; i < board[0].length; i++) {
            solveDFS(board,0,i);
            solveDFS(board,board.length-1,i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] ='X';
                }
                if (board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void solveDFS(char[][] board,int i,int j){
        // 这个的重点就是在于先找一个替代“O”
        if (board[i][j] == 'O'){
            board[i][j] = 'T';
            if (i>0 && board[i-1][j] == 'O'){
                solveDFS(board,i-1,j);
            }
            if (i<board.length-1 && board[i+1][j] == 'O'){
                solveDFS(board,i+1,j);
            }
            if (j>0 && board[i][j-1] == 'O'){
                solveDFS(board,i,j-1);
            }
            if (j<board[0].length-1 && board[i][j+1] == 'O'){
                solveDFS(board,i,j+1);
            }
        }
    }


    public static void main(String[] args){
        Num130SurroundedRegions obj = new Num130SurroundedRegions();
        char[][] tmp = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        obj.solve(tmp);


    }

    public void show(char[][] tmp){
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
    }
}