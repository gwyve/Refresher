package OJ.LeetCode.Num201_250;

public class Num220ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //平方的算法，速度真的很差
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <=k ; j++) {
                if (i+j>=nums.length)
                    continue;
                if ((long)nums[i] - nums[i+j] <=t && (long)nums[i+j] - nums[i] <=t)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Num220ContainsDuplicateIII obj = new Num220ContainsDuplicateIII();
        System.out.println(obj.containsNearbyAlmostDuplicate(new int[]{-1,2147483647},1,2147483647));
    }
}