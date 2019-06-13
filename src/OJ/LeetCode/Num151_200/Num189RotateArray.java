package OJ.LeetCode.Num151_200;

public class Num189RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0|| k == 0)
            return;
        if (k>nums.length)
            k = k%nums.length;
        int n = nums.length;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n-k+i];
        }
        for (int i = n-1; i >=k ; i--) {
            nums[i] = nums[i-k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
    public static void main(String[] args){
        Num189RotateArray obj = new Num189RotateArray();
        int[] tt = new int[]{1};
        obj.rotate(tt,2);
        for (int i = 0; i < tt.length; i++) {
            System.out.println(tt[i]);
        }
    }
}