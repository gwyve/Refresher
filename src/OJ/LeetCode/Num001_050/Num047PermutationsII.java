package OJ.LeetCode.Num001_050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by VE on 2017/6/24.
 */
public class Num047PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,retList,new ArrayList<Integer>(),used);
        return retList;
    }


    private void backtrack(int[] nums,List<List<Integer>> retList,List<Integer> numList,boolean[] used){
        if (numList.size() == nums.length){
            retList.add(new ArrayList<Integer>(numList));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]){
                    continue;
                }
                used[i] = true;
                numList.add(nums[i]);
                backtrack(nums,retList,numList,used);
                used[i] = false;
                numList.remove(numList.size()-1);
            }
        }
    }

    public static void main(String[] args){
        Num047PermutationsII obj = new Num047PermutationsII();
        System.out.println(obj.permuteUnique(new int[]{3,3,0,3}));
    }
}
