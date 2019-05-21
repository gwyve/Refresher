package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.List;

public class Num119PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre;
        List<Integer> res = new ArrayList<Integer>();
        if (rowIndex<0)
            return res;
        res.add(1);
        if (rowIndex == 0)
            return res;
        pre = res;
        for (int i = 1; i < rowIndex+1; i++) {
            res = new ArrayList<Integer>();
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j==i){
                    res.add(1);
                }else{
                    res.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre = res;
        }

        return res;
    }

    public static void main(String[] args){
        Num119PascalsTriangleII obj = new Num119PascalsTriangleII();
        System.out.println(obj.getRow(6));
    }


}