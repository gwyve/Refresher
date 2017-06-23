package OJ.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class Num046Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums==null)
            return null;
        if (nums.length == 0)
            return new ArrayList<List<Integer>>();

        List<List<Integer>> retList = new ArrayList<List<Integer>>();

        backtrack(retList,new ArrayList<Integer>(),nums);
        return retList;

    }

    private void backtrack(List<List<Integer>> retList,List<Integer> numsList,int[] nums){
        if (numsList.size() == nums.length){
            retList.add(new ArrayList<Integer>(numsList));
        }else{
            for (int i = 0; i < nums.length; i++) {
                if (numsList.contains(nums[i]))
                    continue;
                numsList.add(nums[i]);
                backtrack(retList, numsList, nums);
                numsList.remove(numsList.size() -1);
            }
        }
    }

    public static void main(String[] args){
        Num046Permutations obj = new Num046Permutations();
        System.out.println(obj.permute(new int[]{1,2,3}));
    }
}
