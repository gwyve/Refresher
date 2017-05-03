package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public class SimpleSelectionSort extends Sort{
    // 简单选择排序:从序列中选取最小的与第一个交换，在剩下的序列里选取最小的与第二个交换，以此类推

    // 复杂度n^2

    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i ;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]){
                    index = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
    }
}
