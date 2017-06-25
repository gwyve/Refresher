package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/1/16.
 */
public class Num011ContainerWithMostWater {

    public int maxArea(int [] height){
        //从两头开始往中间看而不用两次for
        if (height.length<2)
            return  0;
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            int v = (r - l) * Math.min(height[r],height[l]);
            if (ans < v){
                ans = v;
            }
            if (height[l] < height[r])
                l ++;
            else
                r --;
        }
        return ans;
    }

    public static  void main(String args[]){
        Num011ContainerWithMostWater obj = new Num011ContainerWithMostWater();
        System.out.println(obj.maxArea(new int[]{1,1}));
    }
}
