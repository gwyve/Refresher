package DataStruct.sort;

/**
 * Created by VE on 2017/4/15.
 */
public class StraintInsertSort extends Sort {

    // 直接插入排序:先选择一个数，跟之前的数作对比，如果小于之前的数，之前的数就后移；否则就放在之前的数的后面
    // 稳定的
    // 复杂度:n^2
    @Override
    public void sort(int[] nums){
        if (nums.length<2)
            return;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int x = nums[i];

            while(j>=0 && x<nums[j]){ //此处这个小于号，负责大小序列问题
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = x;
        }
    }


}
