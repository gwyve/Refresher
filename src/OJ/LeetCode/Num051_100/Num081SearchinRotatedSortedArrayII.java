package OJ.LeetCode.Num051_100;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * Created by VE on 2017/7/16.
 */
public class Num081SearchinRotatedSortedArrayII {
    public boolean search(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int mid;
        while (low<=high){
            mid = (low+high)/2;
            if (target == nums[mid])
                return true;
//            下面的这个判断或后面主要是因为有重复的可能，如果缺少了这个条件，在重复的面前会出现错误
            if (nums[mid] < nums[high] || nums[mid] <nums[low]){
                if (target>nums[mid] && target<=nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }else if (nums[mid] > nums[high] || nums[mid] > nums[low]){
                if (target< nums[mid] && target>=nums[low])
                    high = mid-1;
                else
                    low = mid +1;
            }else {
                low++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Num081SearchinRotatedSortedArrayII obj = new Num081SearchinRotatedSortedArrayII();
        System.out.println(obj.search(new int[]{1,3},3));
    }

}
