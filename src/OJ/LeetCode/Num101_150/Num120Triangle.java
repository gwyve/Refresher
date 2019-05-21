package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null || triangle.size()==0)
            return 0;
        for (int i = triangle.size()-2; i >=0 ; i--) {
            List<Integer> current = triangle.get(i);
            List<Integer> below = triangle.get(i+1);
            for (int j = 0; j < current.size(); j++) {
                int min = below.get(j)<below.get(j+1)?below.get(j):below.get(j+1);
                int cur = current.get(j) + min;
                current.remove(j);
                current.add(j,cur);
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args){
        Num120Triangle obj = new Num120Triangle();
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        List<Integer> tmp1 = new ArrayList<Integer>();
        tmp1.add(2);
        tmp.add(tmp1);
        tmp1 = new ArrayList<Integer>();
        tmp1.add(3);
        tmp1.add(4);
        tmp.add(tmp1);

        tmp1 = new ArrayList<Integer>();
        tmp1.add(6);
        tmp1.add(5);
        tmp1.add(7);
        tmp.add(tmp1);

        tmp1 = new ArrayList<Integer>();
        tmp1.add(4);
        tmp1.add(1);
        tmp1.add(8);
        tmp1.add(4);
        tmp.add(tmp1);

        System.out.println(obj.minimumTotal(tmp));
    }

}