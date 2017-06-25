package OJ.LeetCode;

import java.util.Iterator;

/**
 * Created by VE on 2017/6/25.
 */
public class Num050Pow {


    public double myPow1(double x,int n){
        // 这个方法是我想的，简单的实现，但是，超时
        double ret = 1.0;
        if (n>=0){
            for (int i = 0; i < n; i++) {
                ret *= x;
            }
        }else {
            for (int i = n; i < 0; i++) {
                ret /= x;
            }
        }
        return ret;
    }

    public double myPow2(double x,int n){
        //又想了一个，又超时了
        if (n==0)
            return 1;
        boolean isNegtive = false;
        if (n<0){
            isNegtive = true;
        }
        n = Math.abs(n);
        double ret = x;
        int i = 1;
        while (i < n/2) {
            ret *= ret;
            i *= 2;
        }
        while (i<n){
            ret *= x;
            i++;
        }
        if (isNegtive)
            return 1/ret;
        return ret;
    }

    public double myPow(double x, int n){
//        这个是使用迭代，复杂度log(n)
        if (n==0)
            return 1;
        double tmp = myPow(x,n/2);
        if (n%2 == 0){
            return tmp*tmp;
        }else {
            if (n>0)
                return tmp*tmp*x;
            else
                return tmp*tmp/x;
        }
    }

    public static void main(String[] args){
        Num050Pow obj = new Num050Pow();
        System.out.println(obj.myPow(3,6));
    }
}
