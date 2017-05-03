package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public abstract class Sort {
    public void print(int[] nums){
        for (int i=0 ; i <nums.length;i ++){
            System.out.print(nums[i] + " " );
        }
    }

    public abstract void sort(int[] nums);


    public static void main(String args[]){
        Sort obj = new MergeSort();
        System.out.println(obj.getClass().getSimpleName() +":");
        int[] nums = new int[]{2,3,5,4,6,8,9,7};
        obj.sort(nums);
        obj.print(nums);
    }
}
