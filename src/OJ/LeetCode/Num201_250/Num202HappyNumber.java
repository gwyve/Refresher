package OJ.LeetCode.Num201_250;

import java.util.HashSet;
import java.util.Set;

public class Num202HappyNumber {
    public boolean isHappy(int n) {
        Set set = new HashSet<Integer>();
        while (n!=1){
            if (set.contains(n)){
                return false;
            }else {
                set.add(n);
            }
            int k = 0;
            while (n!=0){
                k = k + (n%10)*(n%10);
                n = n / 10;
            }
            n = k;
        }
        return true;
    }
    public static void main(String[] args){
        Num202HappyNumber obj = new Num202HappyNumber();
        System.out.println(obj.isHappy(19));
    }
}