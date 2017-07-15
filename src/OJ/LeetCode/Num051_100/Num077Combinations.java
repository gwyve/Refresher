package OJ.LeetCode.Num051_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VE on 2017/7/15.
 */
public class Num077Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        backtrack(retList,new ArrayList<Integer>(),nums,0,k);
        return retList;
    }

    private void backtrack(List<List<Integer>> retList,List<Integer> numList,int[] nums,int index,int k){
        if (numList.size() == k){
            retList.add(new ArrayList<Integer>(numList));
        }else {
            for (int i = index; i < nums.length; i++) {
                numList.add(nums[i]);
                backtrack(retList,numList,nums,i+1,k);
                numList.remove(numList.size()-1);
            }
        }
    }

    public static void main(String[] args){
        Num077Combinations obj = new Num077Combinations();
        List<List<Integer>> ret = obj.combine(4,2);
        for (int i = 0; i < ret.size(); i++) {
            List<Integer> nu = ret.get(i);
            for (int j = 0; j < nu.size(); j++) {
                System.out.print(nu.get(j)+" ");
            }
            System.out.println();
        }
    }
}
