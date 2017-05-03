package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public class QuickSort extends Sort {

    @Override
    public void sort(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    protected void quickSort(int[] nums,int low,int high){
        if (low<high){
            int privotLoc = partition(nums,low,high);
            quickSort(nums,low,privotLoc-1);
            quickSort(nums,privotLoc+1,high);
        }
    }


    protected void swap(int[] nums,int a ,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    protected int partition(int[] nums,int low,int high){  //这个里面的内容是重点
        int priovtKey = nums[low];
        while (low < high){
            while (low < high && nums[high] >= priovtKey)
                high --;
            swap(nums,low,high);
            while (low < high && nums[low] <= priovtKey)
                low ++;
            swap(nums,low,high);
        }
        return low;
    }

}
