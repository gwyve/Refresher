package OJ.LeetCode.Num101_150;

import java.util.HashSet;
import java.util.Iterator;

public class Num136SingleNumber {
    public int singleNumber(int[] nums) {
        // 太长时间不用异或了，有点忘记了
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ (nums[i]);
        }
        return res;
    }

    public static void main(String[] args){
        Num136SingleNumber obj = new Num136SingleNumber();
        System.out.println(obj.singleNumber(new int[]{4,1,2,1,2}));
    }
}