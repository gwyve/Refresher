package OJ.LeetCode.Num151_200;

public class Num200NumberofIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid,i,j,max);
                    max++;
                }
            }
        }
        return max - 1;
    }
    public void dfs(char[][] grid,int i,int j, int k){
        int n = grid.length;
        int m = grid[0].length;
        if (grid[i][j] == '1'){
            grid[i][j] = (char)('1'+k);
            if (i>0){
                dfs(grid,i-1,j,k);
            }
            if (i<n-1){
                dfs(grid,i+1,j,k);
            }
            if (j>0){
                dfs(grid,i,j-1,k);
            }
            if (j<m-1){
                dfs(grid,i,j+1,k);
            }
        }
    }

    public static void main(String[] args){

        System.out.println((char)('1'+1));
        Num200NumberofIslands obj = new Num200NumberofIslands();
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(obj.numIslands(grid));

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}