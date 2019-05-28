package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.List;

public class Num139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 字符串的问题还是dp，没有别的办法
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String sub = s.substring(i-1,j);
                // 这个位置还是要区别一下if和直接等于的区别的
                if (wordDict.contains(sub) && dp[i-1])
                    dp[j] = true;
            }
        }
        return dp[s.length()];
    }


//    public boolean wordBreak(String s, List<String> wordDict) {
//        // 这个方法目测没错，但是超时间了
//        return helper(s,"",wordDict);
//    }
//    public boolean helper(String s,String curString,List<String> wordDict){
//        boolean res = false;
//        for (int i = 0; i < wordDict.size(); i++) {
//            String tmp = curString + wordDict.get(i);
//            if (tmp.equals(s)){
//                res |= true;
//            }else if (tmp.length()>=s.length()){
//                res |= false;
//            }else {
//                res |= helper(s,tmp,wordDict);
//            }
//        }
//        return res;
//    }

    public static void main(String[] args){
        Num139WordBreak obj = new Num139WordBreak();
        List<String> wordDict = new ArrayList<String>();
        String s = "a";
        String[] strings = new String[]{"a"};
        for (int i = 0; i < strings.length; i++) {
            wordDict.add(strings[i]);
        }
        System.out.println(obj.wordBreak(s,wordDict));

    }

}