package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public class BubbleSort_2 extends Sort{

    // 冒泡的改进
    // 这个主要是利用了最大和最小两个比较
    // 目测复杂度没有改变

    @Override
    public void sort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high){
            for (int i = low; i < high; i++) {
                if (nums[i] > nums[i+1]){
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                }
            }
            high --;
            for (int i = high ; i> low;i--){
                if (nums[i]< nums[i-1]){
                    int tmp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = tmp;
                }
            }
            low ++;
        }
    }



}
