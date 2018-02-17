package OJ.LeetCode.Num051_100;

/**
 * Created by yixina-z on 18/2/17.
 */
public class Num079WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board.length<=0)
            return false;
        if (board[0].length<=0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && search(board,visited,word,i,j,0))
                    return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board,boolean[][] visited,String word,int curm,int curn,int index){
        if(index == word.length()){
            return true;
        }
        if(curm >= board.length || curn >= board[0].length || curm<0 || curn<0 || word.charAt(index) != board[curm][curn] || visited[curm][curn]){
            return false;
        }
        visited[curm][curn] = true;
        if(search(board,visited,word,curm-1,curn,index+1) ||
                search(board,visited,word,curm+1,curn,index+1) ||
                search(board,visited,word,curm,curn-1,index+1) ||
                search(board,visited,word,curm,curn+1,index+1)){
            return true;
        }
        visited[curm][curn] = false;
        return false;
    }
    public static void main(String[] args){

    }
}
