package OJ.LeetCode.Num051_100;

import java.util.Stack;

public class Num085MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        // 这个是沿用Num085的方法做的
        int res = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length==0)
            return res;
        int[] tmp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < tmp.length; j++) {
                if (matrix[i][j] == '1'){
                    tmp[j] += 1;
                }else {
                    tmp[j] = 0;
                }
            }
            int area = largestRectangleArea(tmp);
            res = area>res?area:res;
        }
        return res;
    }

    public int largestRectangleArea(int[] heights){
        int[] newHeights = new int[heights.length+1];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i] = heights[i];
        }
        newHeights[heights.length] = 0;
        heights = newHeights;

        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < heights.length; i++) {
            if (stack.empty() || heights[i] > heights[stack.peek()]){
                stack.push(i);
            }else {
                int cur = stack.pop();
                int length = stack.empty() ? i:(i-stack.peek()-1);
                if (heights[cur] * length > res)
                    res = heights[cur] * length;
                i--;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Num085MaximalRectangle obj = new Num085MaximalRectangle();
        System.out.println(obj.maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }
}