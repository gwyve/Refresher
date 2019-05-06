package OJ.LeetCode.Num001_050;

public class Num029DivideTwoIntegers {

    //这个题，需要注意：
    //  1、int界限的问题，一开始被我忽略
    //  2、先把int转成long，否则好多麻烦
    //  3、一开始，我是一个一个加，速度太慢，后面就是2，4，8，16...这样的速度相加，速度快了很多
    public int divide(int dividend, int divisor) {
        boolean negetive = (dividend<0) !=  (divisor < 0);

        long dividendLong = dividend;
        long divisorLong = divisor;

        if (dividend<0)
            dividendLong = -dividendLong;
        if (divisor<0)
            divisorLong = -divisorLong;

        if (negetive){
            long ret = -divideLong(dividendLong,divisorLong);
            if (ret<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int)ret;
        }else {
            long ret = divideLong(dividendLong,divisorLong);
            if (ret>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else
                return (int)ret;
        }

    }

    public long divideLong(long dividend,long divisor){
        if (dividend<divisor)
            return 0;

        long sum = divisor;
        long divide = 1;
        while ((sum+sum) < dividend){
            sum+=sum;
            divide+=divide;
        }
        return divide + divideLong(dividend-sum,divisor);
    }


    public static void main(String[] args){
        Num029DivideTwoIntegers obj = new Num029DivideTwoIntegers();
        System.out.println(obj.divide(-2147483648,-1));
    }
}