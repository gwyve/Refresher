package OJ.LeetCode.Num001_050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by VE on 2017/2/10.
 */
public class Num0153Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums.length < 3)
            return ret;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if ( i > 0 && nums[i-1] == nums[i]){
                continue;
            }

            int target = - nums[i];

            int j = i + 1;
            int k = nums.length -1;



            while (j<k){

                if (nums[j] + nums[k] == target ){
                    ret.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j ++;
                    k --;
                    while ( j<k && nums[j] == nums[j-1])
                        j++;
                    while ( j<k && nums[k] == nums[k+1])
                        k--;
                }
                else if (nums[j] + nums[k] > target){
                    k--;
                }else{
                    j++;
                }
            }
        }


        return ret;
    }

    public static void main(String args[]){
        Num0153Sum obj = new Num0153Sum();
        System.out.println(obj.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }
}
