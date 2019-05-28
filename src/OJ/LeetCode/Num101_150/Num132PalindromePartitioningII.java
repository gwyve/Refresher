package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.List;

public class Num132PalindromePartitioningII {
    public int minCut(String s) {
        // 这个题的解法，用了两个dp
        // 第一个回文字符串的dp很好理解，第二个实在是有点难以理解了
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = s.length()-1; j > i; j--) {
                if (j-i==1){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i+1][j-1]);
                }
            }
        }
        int[] count = new int[s.length()+1];
        for (int i = s.length()-1; i >= 0 ; i--) {
            count[i] = Integer.MAX_VALUE;
            for (int j = i; j <s.length() ; j++) {
                if (dp[i][j]){
                    count[i] = count[i] < (count[j+1]+1)?count[i]:(count[j+1]+1);
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            System.out.print(count[i] + " ");
        }

        return count[0]-1;
    }



    public static void main(String[] args){
        Num132PalindromePartitioningII obj = new Num132PalindromePartitioningII();
//        System.out.println(obj.minCut("cbbbcc"));
        obj.minCut("cbbbcc");
    }
}