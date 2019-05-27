package OJ.LeetCode.Num101_150;


import java.util.HashSet;

public class Num128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 还是没有明白他这个n的复杂度是咋回事
        HashSet hashSet = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = nums[i] + 1;
            int pre = nums[i]  -1;
            while (hashSet.contains(next)) next++;
            while (hashSet.contains(pre)) pre--;
            int lenght = next-pre-1;
            max = max>lenght?max:lenght;
        }
        return max;
    }
    public static void main(String[] args){
        Num128LongestConsecutiveSequence obj = new Num128LongestConsecutiveSequence();
        System.out.println(obj.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}