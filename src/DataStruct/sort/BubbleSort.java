package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public class BubbleSort extends Sort {
    // 冒泡排序，太早了
    // 复杂度:n^2

    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length -i -1 ; j++) {
                if (nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }
}
