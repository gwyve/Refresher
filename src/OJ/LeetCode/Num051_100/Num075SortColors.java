package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/13.
 */
public class Num075SortColors {
    private void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    private int partition(int[] nums,int low,int high){
        int key = nums[low];
        while (low < high){
            while (low < high && nums[high] >= key)
                high--;
            swap(nums,low,high);
            while (low<high && nums[low] <= key)
                low++;
            swap(nums,high,low);
        }
        return low;

    }
    private void QuickSort(int[] nums,int low,int hight){
        if (low<hight){
            int k = partition(nums,low,hight);
            QuickSort(nums,low,k-1);
            QuickSort(nums,k+1,hight);
        }

    }
    public void sortColors(int[] nums){
        int zero = 0;
        int two = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]==2 && i<two){
                swap(nums,i,two);
                two--;
            }
            while (nums[i]==0 && i>zero){
                swap(nums,i,zero);
                zero++;
            }
        }
    }


    public static void main(String[] args){
        Num075SortColors obj = new Num075SortColors();
        int[] ne = new int[]{0,2,1};
        obj.sortColors(ne);
        for (int i = 0; i < ne.length; i++) {
            System.out.print(ne[i]+" ");
        }
    }
}
