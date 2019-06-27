package OJ.LeetCode.Num201_250;

public class Num215KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        if (k == 0 ||nums == null || nums.length==0 || k>nums.length)
            return 0;

        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = nums[i];
        }
        for (int i = (k-1)/2; i >=0 ; i--) {
            adjast(heap,i,k);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap[0]){
                heap[0] = nums[i];
                adjast(heap,0,k);
            }
        }
        return heap[0];
    }

    public void adjast(int[] heap,int index,int length){
        int child = index*2 + 1;
        while (child<length){
            if (child+1<length && heap[child+1]<heap[child]){
                child++;
            }
            if (heap[child] < heap[index]){
                int tmp = heap[child];
                heap[child] = heap[index];
                heap[index] = tmp;
                index = child;
                child = index*2+1;
            }else {
                break;
            }
        }
    }


    public static void main(String[] args){
        Num215KthLargestElementinanArray obj = new Num215KthLargestElementinanArray();
        System.out.println(obj.findKthLargest(new int[]{7,6,5,4,3,2,1},5));
    }
}