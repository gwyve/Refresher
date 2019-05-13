package OJ.LeetCode.Num051_100;

import java.util.Stack;

public class Num084LargestRectangleinHistogram {

    public int largestRectangleArea2(int[] heights){

        // 这个是利用栈来计算的
        // 使用栈在于维护一个递增栈，如果当前数小弹出顶部

        // 这个方法特别需要注意，如果是个全部都是增的height，那么res永远都是0了，在结尾添加一个0就可以了。
        int[] newHeights = new int[heights.length+1];
        for (int i = 0; i < heights.length; i++) {
            newHeights[i] = heights[i];
        }
        newHeights[heights.length] = 0;
        heights = newHeights;


        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < heights.length; i++) {
            if (stack.empty() || heights[stack.peek()]<heights[i]){
                stack.push(i);
            }else {
                int cur = stack.pop();
                int length = stack.empty()?i:(i - stack.peek() - 1);
                if (heights[cur]*length > res)
                    res = heights[cur]*length;
                i--;
            }
        }
        return res;
    }


    public int largestRectangleArea1(int[] heights){
        // 这个则会比这钱的复杂度小一下，主要在于，如果是递增的直接继续这个，这个主要是按照竖着来找的
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i+1<heights.length && heights[i] < heights[i+1]){
                continue;
            }
            int minH = heights[i];
            for (int j = i; j >=0 ; j--) {
                minH = minH<heights[j]?minH:heights[j];
                int area = minH*(i-j+1);
                res = area>res?area:res;
            }

        }
        return res;
    }



    public int largestRectangleArea(int[] heights) {
        // 我这个的做法，确实是个比较笨的方法，虽然能够ac，但是笨n^2的复杂度吧
        // 这个的做法是划横线来操作，怎么做都是n^2的复杂度
         int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int length = helper(heights,heights[i]);
            if (length*heights[i] > res){
                res = length*heights[i];
            }
        }
        return res;
    }

    public int helper(int[] heights,int height){
        int res = 0;
        int begin = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] >= height){
                if (i-begin + 1 > res){
                    res = i - begin + 1;
                }
            }else {
                begin = i+1;
            }
        }
        return res;
    }


    public static void main(String[] args){
        Num084LargestRectangleinHistogram obj = new Num084LargestRectangleinHistogram();
        System.out.println(obj.largestRectangleArea2(new int[]{2,2}));
    }
}