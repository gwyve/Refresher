package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/8/8.
 */
public class Num067AddBinary {

    public String addBinary(String a, String b) {
        if (a.length()> b.length()){
            return longAddShort(a,b);
        }else {
            return longAddShort(b,a);
        }

    }

    private String longAddShort(String lon,String sho){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i <sho.length(); i++) {
            int a = Integer.parseInt(String.valueOf(lon.charAt(lon.length() - 1 -i)));
            int b = Integer.parseInt(String.valueOf(sho.charAt(sho.length() - 1 -i)));
            if (carry + a + b == 0){
                sb.insert(0,"0");
                carry = 0;
            }else if (carry+a+b==1){
                sb.insert(0, "1");
                carry = 0;
            }else if (carry+a+b == 2){
                sb.insert(0, "0");
                carry = 1;
            }else if(a+b+carry == 3){
                sb.insert(0, "1");
                carry = 1;
            }

        }

        for (int i = sho.length(); i < lon.length(); i++) {
            int a = Integer.parseInt(String.valueOf(lon.charAt(lon.length() -1 - i)));
            if (carry+a == 0){
                sb.insert(0, "0");
                carry = 0;
            }else if (carry+a == 1){
                sb.insert(0, "1");
                carry = 0;
            }else if (carry+a == 2){
                sb.insert(0, "0");
                carry = 1;
            }
        }
        if (carry == 1){
            sb.insert(0, "1");
        }
        return sb.toString();
    }


    public  static void main(String[] args){
        Num067AddBinary obj = new Num067AddBinary();
        System.out.println(obj.addBinary("10100","10"));
    }
}
