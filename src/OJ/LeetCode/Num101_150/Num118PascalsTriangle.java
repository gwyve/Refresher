package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows<1)
            return res;
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        res.add(tmp);
        if (numRows == 1)
            return res;
        tmp = new ArrayList<Integer>();
        tmp.add(1);
        tmp.add(1);
        res.add(tmp);
        if (numRows == 2)
            return res;
        for (int i = 3; i < numRows +1; i++) {
            List<Integer> pre = res.get(i-2);
            tmp = new ArrayList<Integer>();
            for (int j = 0; j < i; j++) {
                if (j==0 || j==i-1){
                    tmp.add(1);
                }else {
                    tmp.add(pre.get(j-1) + pre.get(j));
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args){
        Num118PascalsTriangle obj = new Num118PascalsTriangle();
        System.out.println(obj.generate(5));
    }

}