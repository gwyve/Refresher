package SwordPointOffer;

/**
 * Created by VE on 2017/2/15.
 */
public class Num10Numberof1 {

    //in java ,我还没有写出能够用于负数的

    int numberOf1First(int n){
        //只能为正数的
        int count = 0;
        while(n > 0){
            if ((n&1) == 1){
                count ++;
            }
            n = n >> 1;
        }
        return count;
    }

    int numberOf1Second(int n){
        //java无法实现
        int count = 0;
        int flag = 1;
        while(flag != 0) {
            if ((flag & n)!= 0) {
                count ++;
                flag = flag << 1;
            }
        }
        return count;
    }
    int numberOf1Third(int n){
        int count = 0;
        while(n!=0){
            count ++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String arg[]){
        Num10Numberof1 obj = new Num10Numberof1();
        System.out.println(obj.numberOf1Third(3) + "");
    }
}
