package OJ.LeetCode;

/**
 * Created by VE on 2017/6/22.
 */
public class Num041FirstMissingPositive {

    public int firstMissingPositive(int[] nums){
        int i = 0;
//      这里的重点就是使用while而不是使用for，这里，如果符合条件，i不需要再加1
//      这里主要是，如果换到前面位置的数为小一点的数，需要再次将它判断。
        while (i<nums.length){
            if (nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1] != nums[i]){
                swap(nums,i,nums[i]-1);
            }
            else
                i++;

            print(nums);
        }
        i = 0;
        while ( i<nums.length && nums[i]==i+1)
            i++;
        return i+1;
    }

    private void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    private void print(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static  void main(String[] args){
        Num041FirstMissingPositive obj = new Num041FirstMissingPositive();
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(obj.firstMissingPositive(nums));
        obj.print(nums);
    }
}
