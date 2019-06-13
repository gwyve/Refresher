package OJ.LeetCode.Num151_200;

public class Num190ReverseBits {

    public long reverseBits(int n) {
        // 二进制的数的时候，应该用移位
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n&1)==1){
                res = (res<<1)+1;
                n = n>>1;
            }else {
                res = res<<1;
                n = n>>1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Num190ReverseBits obj = new Num190ReverseBits();
        System.out.println(obj.reverseBits(43261596));
    }
}