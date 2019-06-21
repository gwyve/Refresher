package OJ.LeetCode.Num201_250;

public class Num209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int right = 0, left = 0;
        int res = 0;
        int sum = 0;
        while (right<len){
            while (right<len && sum<s){
                sum += nums[right];
                right++;
            }
            while (left<right && sum>=s){
                int tmp = right-left;
                if (res == 0)
                    res = tmp;
                else
                    res = res<tmp?res:tmp;
                sum -= nums[left];
                left++;
            }
        }
        return res;
    }
    public int minSubArrayLen1(int s, int[] nums) {
        // 平方级别的
        if (s <= 0 || nums == null || nums.length == 0)
            return 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0 ; j--) {
                sum += nums[j];
                if (sum>=s){
                    int tmp = i-j+1;
                    if (res == -1){
                        res = tmp;
                    }else {
                        res = res < tmp?res:tmp;
                    }
                    break;
                }
            }
        }
        return res==-1?0:res;
    }

    public static void main(String[] args){
        Num209MinimumSizeSubarraySum obj = new Num209MinimumSizeSubarraySum();
        System.out.println(obj.minSubArrayLen(15,new int[]{1,2,3,4,5}));
    }
}