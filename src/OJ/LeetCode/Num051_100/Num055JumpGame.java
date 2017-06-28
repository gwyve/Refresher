package OJ.LeetCode.Num051_100;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by VE on 2017/6/27.
 */
public class Num055JumpGame {
    public boolean canJump(int[] nums){
//      这个就是，如果能到这个位置，那么就意味着最大的那个数值能到这里。
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i>max)
                return false;
            max = Math.max(i+nums[i],max);
        }
        return true;
    }

    public static void main(String[] args){
        Num055JumpGame obj = new Num055JumpGame();
        System.out.println(obj.canJump(new int[]{2,0}));
    }
}
