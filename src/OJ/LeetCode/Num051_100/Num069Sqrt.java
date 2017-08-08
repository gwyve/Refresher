package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/8/8.
 */
public class Num069Sqrt {
    public int mySqrt(int x){
        if(x == 0)
            return 0;
        if (x == 1)
            return 1;
        int tmp = x>>1;
        int max = tmp;
        while (x/tmp< tmp){
            max = tmp;
            tmp = tmp >> 1;
        }
        int min = tmp;
        while (max>min){
            if (x / max < max){
                max--;
            }else {
                return max;
            }
        }
        return min;
    }

    public static void main(String[] args){
        Num069Sqrt obj = new Num069Sqrt();
        System.out.println(obj.mySqrt(5));
    }
}
