package OJ.LeetCode.Num051_100;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by VE on 2017/7/17.
 */
public class Num089GrayCode {
    public List<Integer> grayCode(int n){
        List<Integer> ret = new LinkedList<Integer>();
        ret.add(0);
        if (n==0){
            return ret;
        }
        ret.add(1);
        if (n == 1)
            return ret;
        int bit = 1;
        for (int i = 1; i <n ; i++) {
            bit *=2;
            List<Integer> tmp = new LinkedList<Integer>();
            for (int j = ret.size()-1; j >= 0; j--) {
                tmp.add(bit + ret.get(j));
            }
            ret.addAll(tmp);
        }
        return ret;
    }
}
