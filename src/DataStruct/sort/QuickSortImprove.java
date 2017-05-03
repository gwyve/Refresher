package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public class QuickSortImprove extends QuickSort{

    // 快排的优化，在k值得时候快拍，然后再插入排序，当k=8的时候效果最好

    private void qsortImprove(int[] nums,int low,int high,int k){
        if (high - low > k ){
            int privotLoc = partition(nums,low,high);
            qsortImprove(nums,low,privotLoc -1,k);
            qsortImprove(nums,privotLoc + 1,high,k);
        }
    }

    @Override
    protected void quickSort(int[] nums,int low,int high){
        qsortImprove(nums,low,high,8);

        // 插入算法
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int tmp = nums[i];
            while (nums[j]>tmp){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j +1] =tmp;
        }
    }
}
