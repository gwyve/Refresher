package OJ.LeetCode.Num051_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VE on 2017/7/15.
 */
public class Num078Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        backtrack(retList,new ArrayList<Integer>(),nums,0);
        return retList;
    }

    private void backtrack(List<List<Integer>> retList,List<Integer> numList,int[] nums,int index){
        retList.add(new ArrayList<Integer>(numList));
        for (int i = index; i < nums.length; i++) {
            numList.add(nums[i]);
            backtrack(retList,numList,nums,i+1);
            numList.remove(numList.size()-1);
        }
    }

    public static void main(String[] args){
        Num078Subsets obj = new Num078Subsets();
        List<List<Integer>> ret = obj.subsets(new int[]{1,2,3});
        for (int i = 0; i < ret.size(); i++) {
            List<Integer> nu = ret.get(i);
            for (int j = 0; j < nu.size(); j++) {
                System.out.print(nu.get(j)+" ");
            }
            System.out.println();
        }
    }
}
