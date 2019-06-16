package OJ.LeetCode.Num201_250;

public class Num201BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n){
        // 只用看m和n的前几位
        int offset = 0;
        while (m!=n){
            m = m>>1;
            n = n>>1;
            offset++;
        }
        return m<<offset;
    }

//    public int rangeBitwiseAnd(int m, int n) {
//        // 这个暴力的，直接超时
//        int res = Integer.MAX_VALUE;
//        for (int i = m; i <= n; i++) {
//            res = res & i;
//        }
//        return res;
//    }

    public static void main(String[] args){
        Num201BitwiseANDofNumbersRange obj = new Num201BitwiseANDofNumbersRange();
        System.out.println(obj.rangeBitwiseAnd(5,7));
    }
}