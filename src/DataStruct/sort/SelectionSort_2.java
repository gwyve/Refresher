package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public class SelectionSort_2 extends Sort{
    // 二元选择排序，子循环成了之前的1/2
    // 同时选择最大和最小
    // 复杂度 O(n^2)
    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length/2; i++) {
            int minIndex = i;
            int maxIndex = i;
            for (int j = i+1; j < nums.length - i; j++) {
                if (nums[j] > nums[maxIndex]){
                    maxIndex = j;
                    continue;
                }
                if (nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;

            tmp = nums[nums.length-i-1];  //这个1容易掉
            nums[nums.length-i-1] = nums[maxIndex];
            nums[maxIndex] = tmp;

        }
    }
}
