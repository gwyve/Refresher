package OJ.LeetCode.Num201_250;

import java.util.HashMap;
import java.util.Map;

public class Num219ContainsDuplicateII {
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                if ((i - map.get(nums[i])) <= k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 平方级别的速度
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i+j>=nums.length)
                    break;
                if (nums[i] == nums[i+j])
                    return true;
            }
        }
        return false;
    }
}