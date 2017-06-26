package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/6/25.
 */
public class Num031NextPermutation {
    public void nextPermutation(int[] nums){
//        这个想法就是，从后往前排，如果发现增序停止，那么该序列的前一个跟该序列的最后一个进行调换，然后这个序列反序重拍
        if (nums == null)
            return;
        int n = nums.length;
        if (n<2)
            return;

        int index = n-1;
        while (index>0){
            if (nums[index-1] < nums[index])
                break;
            index--;
        }
        if (index==0){
            reverse(nums,0,n-1);
            return;
        }

        int val = nums[index-1];
        int j = n-1;
        while (j>=index){
            if (nums[j]>val)
                break;
            j--;
        }
        swap(nums,index-1,j);
        reverse(nums,index,n-1);
    }
    private void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    private void reverse(int[] nums,int start,int end){
        for (int i = 0; i <= (end - start)/2; i++) {
            swap(nums,start+i,end-i);
        }
    }

    public static void main(String[] args){
        Num031NextPermutation obj = new Num031NextPermutation();
    }
}
