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
    public int[] searchRange1(int[] nums,int target){
//        这个是先二分发搜索
        int[] ret = new int[]{-1,-1};
        if (nums == null || nums.length == 0)
            return ret;
        int start =  0;
        int end = nums.length-1;
        int mid = -1;
        while(start <= end){
            mid = (start + end) /2;
            if (target == nums[mid])
                break;
            if (target < nums[mid]){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        if (nums[mid] != target)
            return ret;
        start = mid;
        end = mid;
        while(start > -1){
            if (nums[start] != target){
                break;
            }
            start --;
        }
        while (end < nums.length ){
            if (nums[end] != target){
                break;
            }
            end ++;
        }
        return  new int[]{start+1,end-1};
    }

    public static  void main(String[] args){
        Num034SearchForARange obj = new Num034SearchForARange();
        int[] ret = obj.searchRange1(new int[]{8},8);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }

    }
}
