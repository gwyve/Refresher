package OJ.LeetCode.Num101_150;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class Num131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        // 这个题就是这样循环的典型
        List<List<String>> res = new ArrayList<List<String>>();
        helper(s,0,new ArrayList<String>(),res);
        return res;

    }

    public void helper(String s,int start, List<String> cur,List<List<String>> res){
        for (int i = 1; start + i < s.length()+1; i++) {
            String curString = s.substring(start,start+i);
            if (isPalindrome(curString)){
                cur.add(curString);
                if (start+i == s.length()){
                    res.add(new ArrayList<String>(cur));
                }
                helper(s,start+i,cur,res);
                cur.remove(cur.size()-1);
            }
        }
    }

    public boolean isPalindrome(String a){
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != a.charAt(a.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Num131PalindromePartitioning obj = new Num131PalindromePartitioning();
        System.out.println(obj.partition(""));
    }

}