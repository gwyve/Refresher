package OJ.LeetCode;

import java.util.Arrays;

/**
 * Created by VE on 2017/6/22.
 */
public class Num043MultiplyStrings {


    public String multiply(String num1,String num2){
        if (num1.length() == 0 || num2.length() ==0)
            return null;
        if (num1.equals("0") || num2.equals("0"))//一开始忘记了0的情况
            return "0";
        int[] tmp = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length()-1; j >= 0; j--) {
                int tmpPro = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');//这个减‘0’很重要
                carry(tmp,tmpPro,i+j+1);
            }
        }
        String ret;
        if (tmp[0] == 0){
            ret = "";
        }else {
            ret = ""+tmp[0];
        }
        for (int i = 1; i < tmp.length; i++) {
            ret += tmp[i];
        }
        return ret;
    }

    private void carry(int[] num,int pro,int index){
        if (pro<10){
            num[index] += pro;
        }else {
            num[index] += pro%10;
            num[index-1] += pro/10;
        }

        while (index >= 0){
            if (num[index] < 10)
                break;
            else {
                num[index-1] += num[index]/10;
                num[index] = num[index] % 10;
            }
            index --;
        }
    }

    public static void main(String[] args){
        Num043MultiplyStrings obj = new Num043MultiplyStrings();
        System.out.println(obj.multiply("999","999"));
    }
}
