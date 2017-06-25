package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/1/13.
 */

// 把字符串中非数字字符前面的数字输出出来
public class Num008StringToInteger {
    public int myAtoi(String str){
        if (str == null || str.length() == 0)
            return 0;

        str = str.trim();

        double tmp = 0;

        int i = 0;

        boolean positive = true;
        if(str.charAt(i) == '+'){
            i ++;
        }else if(str.charAt(i) == '-'){
            positive = false;
            i ++ ;
        }

        for(;i<str.length();i++){
            int dig = str.charAt(i) - '0';
            if(dig >9 || dig <0)
                break;

            if(positive){
                tmp = tmp *10 + dig;
                if(tmp > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }else{
                tmp = tmp *10 - dig;
                if(tmp < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
        }

        int ret = (int) tmp;

        return ret;
    }

    public static void main(String args[]){
        Num008StringToInteger obj = new Num008StringToInteger();
        System.out.println(obj.myAtoi("-21321asfdas564"));
    }
}
