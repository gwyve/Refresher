package OJ.LeetCode.Num201_250;

import java.util.HashSet;

public class Num217ContainsDuplicate {

    public boolean containsDuplicateHash(int[] nums){
        HashSet set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums){
        boolean res = false;
        res = res || creatHeap(nums);
        for (int i = nums.length-1; i >=0 ; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            if (adjast(nums,0,i))
                return true;
        }
        return res;

    }

    public boolean creatHeap(int[] nums){
        for (int i = (nums.length)/2; i >=0 ; i--) {
            if (adjast(nums,i,nums.length))
                return true;
        }
        return false;
    }

    public boolean adjast(int[] nums,int i,int length){
        int child = i*2+1;
        while (child<length){
            if (child+1<length && nums[child+1] == nums[child])
                return true;
            if (child+1<length && nums[child+1] > nums[child])
                child++;
            if (nums[child] == nums[i])
                return true;
            if (nums[child] > nums[i]){
                int tmp = nums[child];
                nums[child] = nums[i];
                nums[i] = tmp;
            }
            i = child;
            child = i*2+1;
        }
        return false;
    }
    public boolean containsDuplicateN(int[] nums) {
        // 最简单n平方的
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        Num217ContainsDuplicate obj = new Num217ContainsDuplicate();
        System.out.println(obj.containsDuplicate(new int[]{17,4,5,3,2,3}));
    }
}