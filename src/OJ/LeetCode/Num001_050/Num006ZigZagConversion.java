package OJ.LeetCode.Num001_050;


/**
 * Created by VE on 2017/1/12.
 */
public class Num006ZigZagConversion {
    public String convert1(String s,int numRows){
        //直接干
        int len = s.length();
        if (len <2 || numRows <2)
            return s;

        String[] ans = new String[numRows];
        for (int i = 0 ; i < ans.length;i++){
            ans[i] = "";
        }
        int row = 0 ,delta = 1;
        for (int i = 0; i < len;i++){
            ans[row] += s.charAt(i);
            row += delta;
            if (row >= numRows){
                row = numRows - 2;
                delta = -1;
            }
            if (row < 0){
                row = 1;
                delta = 1;
            }
        }

        String ret = "";
        for (int i = 0;i < numRows;i++){
            ret += ans[i];
        }
        return ret;
    }

    public String convert2(String s,int numRows){
        //这个循环周期是2 * numRows -2

        int len = s.length();
        if (len <2 || numRows <2)
            return s;

        int lag = 2 * numRows - 2;
        String ret = "";

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += lag) {
                ret += s.charAt(j);
                if (i>0 && i <numRows - 1){
                    int t = j + lag - 2*i;
                    if (t<len){
                        ret += s.charAt(t);
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String arg[]){
        Num006ZigZagConversion obj = new Num006ZigZagConversion();
        System.out.println(obj.convert1("PAYPALISHIRING",3));
    }
}
