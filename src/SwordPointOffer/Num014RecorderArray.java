package SwordPointOffer;

import java.util.Arrays;

/**
 * Created by VE on 2017/3/1.
 */
public class Num014RecorderArray {

    int[] ReorderOddEven1(int[] data){
        // 把奇数都放到偶数前面
        // 两个指针的做法
        if (data == null || data.length==0)
            return null;

        int length = data.length;
        int p1 = 0;
        int p2 = length-1;

        while (p1 < p2){
            if (data[p1]%2 == 0){
                if (data[p2]%2 == 1){
                    swap(data,p1,p2);
                }else {
                    p2 --;
                }
            }else{
                p1 ++;
            }
        }

        return data;
    }
    void swap(int[] data,int p1,int p2){
        int tmp = data[p1];
        data[p1] = data[p2];
        data[p2] = tmp;
    }

    public static void main(String arg[]){
        Num014RecorderArray obj = new Num014RecorderArray();
        System.out.println(Arrays.toString(obj.ReorderOddEven1(new int[]{1,2,3,4,6,8,9,7,5,6,7})));
    }
}
