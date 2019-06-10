package OJ.LeetCode.Num151_200;

public class Num172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        // 应该看到5，因为2比5多；
        // 这里 举个例子 28和29是一样的，所以 n= n/5就可以了
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
    public static void main(String[] args){
        Num172FactorialTrailingZeroes obj = new Num172FactorialTrailingZeroes();
        System.out.println(obj.trailingZeroes(10));
    }
}