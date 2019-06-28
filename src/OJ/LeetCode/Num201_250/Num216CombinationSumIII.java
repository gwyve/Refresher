package OJ.LeetCode.Num201_250;

import java.util.ArrayList;
import java.util.List;

public class Num216CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        int sum = 0;
        helper(res,new ArrayList<Integer>(),1,k,sum,n);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> cur,int i,int k,int sum,int n){
        if (k == 0 && sum == n){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if (k == 0 || sum>n)
            return;
        for (int j = i; j < 10; j++) {
            sum += j;
            cur.add(j);
            helper(res,cur,j+1,k-1,sum,n);
            sum-=j;
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args){
        Num216CombinationSumIII obj = new Num216CombinationSumIII();
        System.out.println(obj.combinationSum3(3,18));

    }
}