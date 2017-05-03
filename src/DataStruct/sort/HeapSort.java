package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public class HeapSort extends Sort{
    // 堆排序
    // 这个思路就是，需要从小到大的排列的话，那么每次生成大顶堆。
    // 先构造一个堆，然后再每次把顶跟最后一个进行交换。
    // 不稳定
    // 复杂度：nlog(n)


    @Override
    public void sort(int[] nums) {
        BuildingHeap(nums);
        for (int i = nums.length-1; i >= 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            HeapAdjust(nums,0,i);
        }
    }

    private void BuildingHeap(int[] nums){
        for (int i = (nums.length-1)/2; i >= 0; i--) {
            HeapAdjust(nums,i,nums.length);
        }
    }

    private  void HeapAdjust(int[] nums,int index,int length){
        int tmp = nums[index];
        int child = 2 *index +1;
        while (child < length){
            if (child + 1 < length && nums[child] < nums[child + 1]){
                child ++;
            }
            if (nums[child] > nums[index]){
                nums[index] = nums[child];
                index = child;
                child = child * 2 + 1;
            }else {
                break;
            }
            nums[index] = tmp;
        }
    }
    
    
}
