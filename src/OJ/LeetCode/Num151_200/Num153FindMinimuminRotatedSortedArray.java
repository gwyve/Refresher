package OJ.LeetCode.Num151_200;

public class Num153FindMinimuminRotatedSortedArray {
    public int findMinLogN(int[] nums){
        return helper(nums,0,nums.length-1);
    }
    public int helper(int[] nums,int low,int high){
        // 如果子序列 从low到high都是递增的，那么直接返回
        if (nums[low]<nums[high])
            return nums[low];
        if (high-low == 0){
            return nums[low];
        }else if (high-low == 1){
            return nums[low]<nums[high]?nums[low]:nums[high];
        }else {
            int mid = (low+high)/2;
            if (nums[low]<nums[mid]){
                return helper(nums,mid,high);
            }else {
                return helper(nums,low,mid);
            }
        }
    }
    public int findMin(int[] nums) {
        // 这是个n的复杂度，垃圾也能ac
        if(nums== null || nums.length == 0){
            return -1;
        }
        int res = nums[0];
        if (nums.length ==1)
            return res;
        if (nums[1]>nums[0]){
            for (int i = 1; i < nums.length; i++) {
                if (nums[i-1]>nums[i]){
                    res = nums[i];
                    break;
                }
            }
        }else {
            for (int i = 0; i < nums.length; i++) {
                // 这里这个等号需要注意
                if (nums[i]<=res){
                    res = nums[i];
                }else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Num153FindMinimuminRotatedSortedArray obj = new Num153FindMinimuminRotatedSortedArray();
        System.out.println(obj.findMinLogN(new int[]{1,2,3}));
    }
}