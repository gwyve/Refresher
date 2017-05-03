package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public class BubbleSort_1 extends Sort{
    // 冒泡的改进
    // 主要是用来记录交换的位置，这个位置之后的，都是排好序列的
    @Override
    public void sort(int[] nums) {
        int i = nums.length -1;
        while (i > 0){
            int pos = 0;
            for (int j = 0; j < i ;j++){
                if (nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    pos = j;
                }
            }
            i = pos;
        }
    }
}
