package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public class ShellSort extends Sort{

    //希尔排序，先分出小的序列，在小序列里插入排序，然后再整体排序
    // 不稳定
    //希尔排序的时间复杂度，需要根据如何选取子序列来确定；所以不好说复杂度
    // 最后都要用dk=1进行插入排序



    @Override
    public void sort(int[] nums){
        int dk = nums.length / 2;
        while (dk >= 1){
            shellInsertSort(nums,dk);
            dk = dk/2;
        }
    }

    private void shellInsertSort(int nums[],int dk){
        for (int i = dk; i < nums.length; i++) {
            int j = i - dk;
            int x = nums[i];
            while (j>=0 && x <nums[j] ){  //此处这个小于号，负责大小序列问题
                nums[j+dk] = nums[j];
                j -= dk;
            }
            nums[j+dk] = x;
        }
    }
}
