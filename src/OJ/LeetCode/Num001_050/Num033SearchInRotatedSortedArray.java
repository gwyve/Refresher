package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/6/2.
 */
public class Num033SearchInRotatedSortedArray {
//    这个方法，真的挺好的
    public int search(int[] nums,int target){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
//            这个地方的等于号，使得只有一个元素
            int mid = (start + end )/2;
            if (target == nums[mid])
                return mid;

//            先分成两种情况
            if (nums[start] <= nums[mid]){
                if (target >= nums[start] && target < nums[mid]){
//                    这个等于号和下面的-1决定了很多死循环都避免了
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else {
                    end = mid -1;
                }
            }
        }
        return -1;
    }

    public static  void main(String[] args){
        Num033SearchInRotatedSortedArray obj = new Num033SearchInRotatedSortedArray();
        System.out.println(obj.search(new int[]{1,2},2));
    }
}
