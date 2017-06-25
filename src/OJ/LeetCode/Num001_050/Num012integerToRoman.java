package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/1/16.
 */
public class Num012integerToRoman {

    public String intToRoman(int num){
        String[][] roman = {
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}

        };

        String ret = "";
        int digit = 0;
        while(num > 0){
            int remain = num % 10;
            ret = roman[digit][remain] + ret;
            digit ++;
            num /= 10;
        }
        return ret;
    }

    public static void main(String args[]){
        Num012integerToRoman obj = new Num012integerToRoman();
        System.out.println(obj.intToRoman(3561));
    }
}
