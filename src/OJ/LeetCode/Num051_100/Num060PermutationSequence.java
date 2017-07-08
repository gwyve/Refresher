package OJ.LeetCode.Num051_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VE on 2017/7/8.
 */
public class Num060PermutationSequence {
    public String getPermutation(int n,int k){
        List nums = new ArrayList();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();
        factorial[0] = 1;

        k--;//这个很重要
//      这个主要是因为ArrayList nums里面从0开始有关

        int sum = 1;
        for (int i = 1; i <= n ; i++) {
            sum *= i;
            factorial[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }

        for (int i = 1; i <= n; i++) {
            int index = k/factorial[n-i];
            System.out.println(index);
            sb.append(String.valueOf(nums.get(index)));
            nums.remove(nums.get(index));
            k -= index*factorial[n-i];
        }

        return sb.toString();
    }

    public static void main(String[] args){
        Num060PermutationSequence obj = new Num060PermutationSequence();
        System.out.println(obj.getPermutation(3,1));
    }
}
