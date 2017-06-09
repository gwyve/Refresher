package OJ.LeetCode;

/**
 * Created by VE on 2017/6/9.
 */
public class Num034SearchForARange {
    public int[] searchRange(int[] nums,int target){
//        这个就是正常走，没有考虑复杂度
        int[] ret = new int[] {-1,-1};
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]){
                if(ret[0] == -1)
                    ret[0] = i;
                ret[1] = i;
            }else if (ret[0] != -1 &&  target == nums[i-1] ){
                return ret;
            }
        }
        return ret;
    }

    public static  void main(String[] args){
        Num034SearchForARange obj = new Num034SearchForARange();
        int[] ret = obj.searchRange(new int[]{8,8},8);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }

    }
}
