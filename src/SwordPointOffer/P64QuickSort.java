package SwordPointOffer;

import java.util.Arrays;

/**
 * Created by VE on 2017/2/14.
 */
public class P64QuickSort {

    public static int[] quickSort(int[] data){
        return quickSort(data,data.length,0,data.length-1);
    }

    public static int[] quickSort(int[] data,int length, int start,int end){

        if (start == end)
            return null;

        int index = partition(data,length,start,end);
        if (index > start)
            partition(data,length,start,index-1);
        if (index < end)
            partition(data,length,index+1,end);
        return data;
    }

    public static int partition(int[] data,int length,int start,int end){
        int index = (start + end)/2;
        swap(data,index,end);

        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (data[i] < data[end]){
                small ++;
                if (i != small)
                    swap(data,i,small);
            }
        }

        small ++;
        swap(data,small,end);

        return small;
    }
    public static void swap(int[] data, int a ,int b){
        int tmp = data[b];
        data[b] = data[a];
        data[a] = tmp;
    }


    public static  void main(String arg[]){
        int[] aa = quickSort(new int[]{2,5,69,8,73,2,24,4,6,3});
        System.out.println(Arrays.toString(aa));

    }
}
