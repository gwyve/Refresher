package OJ.LeetCode;

/**
 * Created by VE on 2017/1/12.
 */
public class Num007ReverseInteger {

    public int reverse(int x) {

        boolean flag = true;//是否为正数
        if (x == 0)
            return 0;
        if (x < 0){
            flag = false;
            x = 0 - x;
        }

        long ret = 0;
        while(x > 0){
            ret = ret *10 + x%10;
            x  /= 10;
        }

        if (ret  > Integer.MAX_VALUE)
            return 0;

        if (!flag){
            return  (int)ret * -1;
        }
        return (int)ret;

    }


    public static void main(String arg[]){
        Num007ReverseInteger obj = new Num007ReverseInteger();
        System.out.println(obj.reverse(1534236469));
    }
}
