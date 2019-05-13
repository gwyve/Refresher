package OJ.LeetCode.Num051_100;

public class Num084LargestRectangleinHistogram {




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
        System.out.println(obj.largestRectangleArea1(new int[]{2, 1, 5, 6, 2, 3}));
    }
}