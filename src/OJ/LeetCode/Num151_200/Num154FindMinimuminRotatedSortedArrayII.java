package OJ.LeetCode.Num151_200;

public class Num154FindMinimuminRotatedSortedArrayII {
    public int findMinLogN(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while (left<right && nums[left] >= nums[right]){
            int mid = (left + right)/2;
            if (nums[mid] < nums[left]){
                right = mid;
            }else if (nums[mid] == nums[left]){
                left ++;
            }else {
                left = mid+1;
            }
        }
        return nums[left];
    }

    public int findMin(int[] nums) {
        // 傻瓜一样的做法
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            res = res<nums[i]?res:nums[i];
        }
        return res;
    }
    public static void main(String[] args){
        Num154FindMinimuminRotatedSortedArrayII obj = new Num154FindMinimuminRotatedSortedArrayII();
        System.out.println(obj.findMinLogN(new int[]{3,3,3,1,3}));
    }
}