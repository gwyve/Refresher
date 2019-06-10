package OJ.LeetCode.Num151_200;

import java.util.ArrayList;
import java.util.List;

public class Num166FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        // 主要就是在看这个边界的问题
        List<Long> list = new ArrayList<Long>();
        StringBuilder sb = new StringBuilder();
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        String pre ="";
        if (numeratorLong<0 && denominatorLong>0){
            pre = "-";
            numeratorLong = -numeratorLong;
        }else if (numeratorLong>0 && denominatorLong<0){
            pre = "-";
            denominatorLong = -denominatorLong;
        }else if (numeratorLong<0 && denominatorLong<0){
            denominatorLong = -denominatorLong;
            numeratorLong = -numeratorLong;
        }
        pre = pre+""+numeratorLong/denominatorLong;
        numeratorLong = numeratorLong%denominatorLong;
        while (numeratorLong!=0){
            if (list.contains(numeratorLong)){
                int startIndex = list.indexOf(numeratorLong);
                return pre+"."+sb.toString().substring(0,startIndex)+"("+sb.toString().substring(startIndex)+")";
            }
            list.add(numeratorLong);
            numeratorLong = 10*numeratorLong;
            sb.append(numeratorLong/(long)denominatorLong);
            numeratorLong = numeratorLong%denominatorLong;
        }
        if (sb.length()<1)
            return pre;
        return pre+"."+sb.toString();
    }

    public static void main(String[] args){
        Num166FractiontoRecurringDecimal obj = new Num166FractiontoRecurringDecimal();
        System.out.println(obj.fractionToDecimal(-1,
                -2147483648));
    }
}