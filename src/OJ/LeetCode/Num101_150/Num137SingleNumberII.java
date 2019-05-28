package OJ.LeetCode.Num101_150;

import java.util.HashMap;

public class Num137SingleNumberII {
    public int singleNumber(int[] nums) {
        // 这个题应该是这类题的终极解法
        int[] count  = new int[32];
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            int bit = 0;
            for (int j = 0; j < nums.length; j++) {
                bit += (nums[j] >> i) & 1;
                bit = bit % 3;
                // 这个位置的这个3是可以用来扩展的
            }
            res += (bit<<i);
        }
        return res;
    }
}