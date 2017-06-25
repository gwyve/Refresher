package OJ.LeetCode;

/**
 * Created by VE on 2017/1/17.
 */
public class Num013RomanToInteger {

    public int romanToInt(String s){
        int ret = toInt(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (toInt(s.charAt(i-1)) < toInt(s.charAt(i))){
                ret += toInt(s.charAt(i)) - 2 * toInt(s.charAt(i-1));
            }else {
                ret += toInt(s.charAt(i));
            }
        }
        return ret;
    }

    public int toInt(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public  static void main(String are[]){
        Num013RomanToInteger obj = new Num013RomanToInteger();
        System.out.println(obj.romanToInt("XLIV"));
    }


}
