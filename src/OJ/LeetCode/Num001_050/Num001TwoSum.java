package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/1/6.
 */

//题目位置：https://leetcode.com/problems/two-sum/
public class Num001TwoSum {
    public int[] twoSum(int[] nums , int target){

        int lentgh = nums.length;

        for(int i = 0 ;i <lentgh;i++){
            for(int j = i+1;j<lentgh;j++ ){
                if (nums[i] + nums[j] == target)
                    return new int[]{i,j};
            }
        }
        return null;

    }

    public static void main(String[] args){
        Num001TwoSum obj = new Num001TwoSum();
        int[] ret = obj.twoSum(new int[]{3,2,4},6);
        for (int i = 0; i < ret.length -1;i++)
        {
            System.out.print(ret[i] + ",");
        }
        System.out.print(ret[ret.length -1]);
    }


}