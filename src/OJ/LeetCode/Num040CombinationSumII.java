package OJ.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yixina-z on 17/6/17.
 */
public class Num040CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length ==0 || target == 0){
            return retList;
        }
        Arrays.sort(candidates);
        backtrick(retList,new ArrayList<Integer>(),candidates,target,0);
        return retList;
    }

    private void backtrick(List<List<Integer>> retList, List<Integer> numList,int[] nums, int remain,int start){
        if( remain < 0){
            return;
        }else  if(remain == 0){
            retList.add(new ArrayList<Integer>(numList));
        }else{
            for (int i = start ; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i-1]) continue;;
                numList.add(nums[i]);
                backtrick(retList,numList,nums,remain - nums[i],i+1);
                numList.remove(numList.size() -1);
            }
        }
    }

}
