package OJ.LeetCode.Num201_250;

import java.util.LinkedList;
import java.util.List;

public class Num204CountPrimes {
    public int countPrimes(int n) {
        // 这个方法也是参考别人的，虽然是个easy的题，这里还是参考了别人的想法了
        int res = 0;
        boolean[] isNotPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (isNotPrimes[i-1] == false){
                res ++;
                for (int j = 2; j*i < n; j++) {
                    isNotPrimes[i*j-1] = true;
                }
            }
        }
        return res;
    }



    public static void main(String[] args){
        Num204CountPrimes obj = new Num204CountPrimes();
        System.out.println(obj.countPrimes(19));

    }
}