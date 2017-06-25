package OJ.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yixina-z on 17/6/15.
 */
public class Num039CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        List retList = new ArrayList<List<Integer>>();
        if (candidates==null || candidates.length ==0 )
            return retList;
        Arrays.sort(candidates);
        backtrick(retList,new ArrayList<Integer>(),candidates,target,0);
        return retList;

    }
    private void backtrick(List<List<Integer>> list, List<Integer> numList, int[] nums, int remain,int start){
        if (remain<0){
            return;
        }else if (remain == 0){
            list.add(new ArrayList<Integer>(numList));// 这个位置的重新建立一个对象很有有必要
        }else {
            for (int i = start ; i < nums.length;i ++){
                numList.add(nums[i]);
                backtrick(list,numList,nums,remain-nums[i],i);
                numList.remove(numList.size()-1);
            }
        }
    }



}
