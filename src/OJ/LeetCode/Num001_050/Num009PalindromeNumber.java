package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/1/13.
 */
//看一个整数是不是回文数
public class Num009PalindromeNumber {

    public boolean isPalindrome1(int x){
        //这个使用了额外的空间，竟然能通过
        int tmp = x;
        int trans = 0;
        while(tmp > 0 ){
            trans = trans*10 + tmp % 10;
            tmp /= 10;
        }

        System.out.println(trans);
        return x == trans;
    }

    public boolean isPalindrome(int x) {
        //这个不能判断1001，这样的数
        if ( x < 0)
            return false;
        if (x < 10)
            return true;
        int base = 1;
        while( x/base > 10)
            base *= 10;

        while( x > 0 ){
            int right = x % 10;
            int left = x / base;
            if (right!=left)
                return false;

            x = x - base * left;
            x /= 10;
            base /=100;
        }
        return true;
    }

    public static void main(String arg[]){
        Num009PalindromeNumber obj = new Num009PalindromeNumber();
        System.out.println(obj.isPalindrome1(1001));
    }
}
