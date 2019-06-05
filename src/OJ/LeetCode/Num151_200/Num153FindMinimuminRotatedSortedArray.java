package OJ.LeetCode.Num151_200;

public class Num153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
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
        System.out.println(obj.findMin(new int[]{2,1}));
    }
}