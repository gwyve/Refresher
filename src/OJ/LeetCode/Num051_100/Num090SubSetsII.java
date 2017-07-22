package OJ.LeetCode.Num051_100;

import org.omg.CORBA.BAD_CONTEXT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */
public class Num090SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> retList = new ArrayList<List<Integer>>();
        backtrack(retList, new ArrayList<Integer>(), nums, 0);
        return retList;
    }

    private void backtrack(List<List<Integer>> retList,List<Integer> numList, int[] nums,int index){
       if (index<= nums.length){
           retList.add(new ArrayList<Integer>(numList));
       }
        int i = index;
        while (i < nums.length){
            numList.add(nums[i]);
            backtrack(retList,numList,nums,i+1);
            numList.remove(numList.size()-1);
            i++;
//           这个才是这个防止重复的关键
//            这个算法比我之前的那些要高明许多
            while (i< nums.length && nums[i] == nums[i-1]){
                i++;
            }
        }
    }


    private void print(List<List<Integer>> retList){
        for (int i = 0; i < retList.size(); i++) {
            List<Integer> numList = retList.get(i);
            for (int j = 0; j < numList.size(); j++) {
                System.out.print(numList.get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Num090SubSetsII obj = new Num090SubSetsII();
        List<List<Integer>> retList = obj.subsetsWithDup(new int[]{1, 2, 3});
        obj.print(retList);
    }


}
