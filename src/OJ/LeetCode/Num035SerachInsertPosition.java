package OJ.LeetCode;

/**
 * Created by VE on 2017/6/9.
 */
public class Num035SerachInsertPosition {
    public int searchInsert(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int mid = (low + high) / 2;
        while (low <= high){
            mid = (low + high)/2;
            if (target == nums[mid])
                return mid;
            if (target < nums[mid])
                high = mid -1 ;
            else
                low = mid + 1;
        }
        if (target > nums[mid])
            return mid + 1;
        else
            return mid;
    }

    public static void main(String[] args){
        Num035SerachInsertPosition obj = new Num035SerachInsertPosition();
        System.out.println(obj.searchInsert(new int[]{1,3,5,6},0));
    }
}
