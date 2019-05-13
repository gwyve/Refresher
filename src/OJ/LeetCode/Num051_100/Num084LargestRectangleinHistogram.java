package OJ.LeetCode.Num051_100;

public class Num084LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        // 我这个的做法，确实是个比较笨的方法，虽然能够ac，但是笨n^2的复杂度吧
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
        System.out.println(obj.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}