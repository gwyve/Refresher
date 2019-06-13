package OJ.LeetCode.Num151_200;

public class Num191Numberof1Bits {
    public int hammingWeight(int n) {
        // >>> 与>> 的差别
        /**
          <<      :     左移运算符，num << 1,相当于num乘以2

         >>      :     右移运算符，num >> 1,相当于num除以2

         >>>    :     无符号右移，忽略符号位，空位都以0补齐
         */
        int res = 0;
        while (n!=0){
                res = res+ (n&1) ;
            n = n>>>1;
        }
        return res;
    }
    public static void main(String[] args){
        Num191Numberof1Bits obj = new Num191Numberof1Bits();
        System.out.println(obj.hammingWeight(2333322));
    }
}