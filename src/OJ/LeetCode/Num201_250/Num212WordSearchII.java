package OJ.LeetCode.Num201_250;

import java.util.ArrayList;
import java.util.List;

public class Num212WordSearchII {


    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0)
            return new ArrayList<String>();
        if (board== null || board.length == 0 || board[0].length == 0)
            return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            Trie run = root;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                int tmp = word.charAt(j) - 'a';
                if (run.children[tmp] == null)
                    run.children[tmp] = new Trie();
                run = run.children[tmp];
            }
            run.num = i;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,res,words,i,j,root);
            }
        }
        return res;
    }

    public void dfs(char[][] board, List<String> res,String[] words,int i,int j,Trie run){
        int m = board.length;
        int n = board[0].length;
        if (board[i][j] == '0')
            return;
        int tmp  = board[i][j] - 'a';
        if (run.children[tmp] == null)
            return;
        if (run.children[tmp].num!=-1){
            res.add(words[run.children[tmp].num]);
            run.children[tmp].num = -1;
        }
        run = run.children[tmp];

        char cur = board[i][j];
        board[i][j] ='0';
        if (i-1>=0){
            dfs(board,res,words,i-1,j,run);
        }
        if (i+1<m){
            dfs(board,res,words,i+1,j,run);
        }
        if (j-1>=0){
            dfs(board,res,words,i,j-1,run);
        }
        if (j+1<n){
            dfs(board,res,words,i,j+1,run);
        }
        board[i][j] =cur;
    }

    private class Trie{
        Trie[] children = new Trie[26];
        int num = -1;
    }


    public static void main(String[] args){
        Num212WordSearchII obj = new Num212WordSearchII();
//        System.out.println(obj.findWords(
//                new char[][]{
//                        {'a','a'}
//                },new String[] {"aaa"}
//        ));
        System.out.println(obj.findWords(
                new char[][]{
                        {'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}
                },new String[] {"oath","pea","eat","rain"}
        ));
    }

}