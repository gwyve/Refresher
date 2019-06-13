package OJ.LeetCode.Num151_200;

public class Num174DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dungeon.length-1][dungeon[0].length-1] = 1 - dungeon[dungeon.length-1][dungeon[0].length-1];
        dp[dungeon.length-1][dungeon[0].length-1] = 1>dp[dungeon.length-1][dungeon[0].length-1]?1:dp[dungeon.length-1][dungeon[0].length-1];
        for (int i = dungeon.length-2; i >=0 ; i--) {
            dp[i][dungeon[0].length-1] = dp[i+1][dungeon[0].length-1] - dungeon[i][dungeon[0].length-1];
            dp[i][dungeon[0].length-1] = dp[i][dungeon[0].length-1] > 1?dp[i][dungeon[0].length-1]:1;
        }
        for (int i = dungeon[0].length-2; i >=0 ; i--) {
            dp[dungeon.length-1][i] = dp[dungeon.length-1][i+1] - dungeon[dungeon.length-1][i];
            dp[dungeon.length-1][i] = dp[dungeon.length-1][i]>1?dp[dungeon.length-1][i]:1;
        }
        for (int i = dungeon.length-2; i >=0 ; i--) {
            for (int j = dungeon[0].length-2; j >= 0 ; j--) {
                int val = (dp[i][j+1]<dp[i+1][j]?dp[i][j+1]:dp[i+1][j]) - dungeon[i][j];
                dp[i][j] = val>1?val:1;
            }
        }
        return dp[0][0];

    }


//    public int calculateMinimumHP(int[][] dungeon) {
//        // 递归的方法超时了n平方级别的，超时了
//        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
//            return 0;
//        return 1 - helper(dungeon,0,0,0,0);
//    }
//
//    public int helper(int[][] dungeon, int min, int cur, int row,int col){
//        int down = Integer.MIN_VALUE;
//        int right = Integer.MIN_VALUE;
//        if (row == dungeon.length-1 && col == dungeon[0].length-1){
//            int temp = cur + dungeon[row][col];
//            return temp<min?temp:min;
//        }
//        cur = cur + dungeon[row][col];
//        min = min<cur?min:cur;
//
//        if (row<dungeon.length-1){
//            down = helper(dungeon,min,cur,row+1,col);
//        }
//        if (col<dungeon[0].length-1){
//            right = helper(dungeon,min,cur,row,col+1);
//        }
//        return right>down?right:down;
//    }

    public static void main(String[] args){
        Num174DungeonGame obj = new Num174DungeonGame();
//        System.out.println(obj.calculateMinimumHP(new int[][]{
//                {-2,-3,3},
//                {-5,-10,1},
//                {10,30,-5}
//        }));
        System.out.println(obj.calculateMinimumHP(new int[][]{{100}}));
    }

}