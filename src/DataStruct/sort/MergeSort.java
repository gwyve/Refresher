package DataStruct.sort;

/**
 * Created by VE on 2017/4/16.
 */
public class MergeSort extends Sort{
    // 归并排序

    @Override
    public void sort(int[] nums) {
        int[] rn = new int[nums.length];
        mergeSort(nums,rn);

    }

    private void swapArray(int[] a,int[] b){
        if (a.length != b.length){
            System.out.println("!!!!!");
            return;
        }
        int[] tmp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            tmp[i] = a[i];
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
        for (int i = 0; i < a.length; i++) {
            b[i] = tmp[i];
        }


    }

    private void mergeSort(int[] nums,int[] rf){
        int len = 1;
        int[] tmp = new int[nums.length];
        while (len < nums.length){
            int s = len;
            len = 2*s;
            int i = 0;
            while (i +len <nums.length){
                merge(nums,rf,i,i+s-1,i+len-1);
                i = i +len;
            }
            if (i+s<nums.length){
                merge(nums,rf,i,i+s-1,nums.length-1);
            }
            swapArray(nums,rf);
        }
    }

    // rf是辅助空间
    private void merge(int[] nums,int[] rf,int i ,int m,int n){
        // j 是后面半拉的index，k是新序列的index

        for (int j = m+1,k =i; j<=n && i<=m ; k++) {
            if (nums[j] < nums[i]){
                rf[k] = nums[j];
                j++;
            }else {
                rf[k] = nums[i];
                i++;
            }
            while ( j <= n){
                rf[k] = nums[j];
                j ++;
            }
            while ( i<= m){
                rf[k] = nums[i];
                i++;
            }
        }
    }

}
