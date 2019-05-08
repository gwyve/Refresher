package OJ.LeetCode.Num001_050;

public class Num045JumpGameII {
    
    public int jump(int[] nums){
        int flag[] = new int[nums.length];
        for (int i = 1; i < flag.length; i++) {
            flag[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < i+1+nums[i]; j++) {
                if (j < flag.length && flag[j] > flag[i])
                    flag[j] = flag[i]+1;
            }
        }

        return flag[flag.length-1];
    }
    
    public static void main(String[] args){
        Num045JumpGameII obj = new Num045JumpGameII();
        System.out.println(obj.jump(new int[]{2,3,1,1,4}));
    }
}