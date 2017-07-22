package OJ.LeetCode.Num051_100;

/**
 * Created by Administrator on 2017/7/23.
 */
public class Num066PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >=0; i--) {
            if (carry == 0)
                break;
            if (digits[i]+carry == 10 ){
                digits[i] =0;
                carry =1;
            }else {
                digits[i] = digits[i] + carry;
                carry = 0;
            }
        }
        if (carry==1){
            int[] ret = new int[digits.length+1];
            for (int i = digits.length-1; i >0 ; i--) {
                ret[i+1] = digits[i];
            }
            ret[0] = carry;
            return ret;
        }

        return digits;
    }

    public static void main(String[] args){
        Num066PlusOne obj = new Num066PlusOne();
        int[] num =  obj.plusOne(new int[]{9,9});
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
        }
    }
}
