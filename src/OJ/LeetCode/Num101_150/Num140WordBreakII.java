package OJ.LeetCode.Num101_150;

import java.util.ArrayList;
import java.util.List;

public class Num140WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
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
        List<List<String>> tmp = new ArrayList<List<String>>();
        if (dp[dp.length-1]){
            helper(s,wordDict,0,"",res);
        }
        return res;
    }

    public void helper(String s,List<String> wordDict,int index,String curString, List<String> res){
        // 把一些替换string的方法去掉就可以通过了，但是，速度仍然很慢。
        for (int i = index+1; i<=s.length(); i++) {
            String curWord = s.substring(index,i);
            if (wordDict.contains(curWord)){
                String tmp = curString + " " + curWord;
                if (curString.length()==0){
                    tmp = curWord;
                }
                if (i == s.length()){
                    res.add(tmp);
                }else {
                    helper(s,wordDict,i,tmp,res);
                }
            }

        }
    }



//    public List<String> wordBreak(String s, List<String> wordDict) {
//        // 不出所料，又超时了
//        List<String> res = new ArrayList<String>();
//        helper(s,wordDict,"",res);
//        return res;
//    }
//
//    public void helper(String s,List<String> wordDict,String curString,List<String> res){
//        for (int i = 0; i < wordDict.size(); i++) {
//            String tmp = curString+" " + wordDict.get(i);
//            if (curString.length()<1)
//                tmp = wordDict.get(i);
//            if (tmp.replace(" ","").equals(s)){
//                res.add(tmp);
//            }else if (tmp.replace(" ","").length()>=s.length()){
//                continue;
//            }else {
//                helper(s,wordDict,tmp,res);
//            }
//        }
//    }


    public static void main(String[] args){
        Num140WordBreakII obj = new Num140WordBreakII();
        List<String> wordDict = new ArrayList<String>();
        String s = "catsanddog";
        String[] strings = new String[]{"cat", "cats", "and", "sand", "dog"};
        for (int i = 0; i < strings.length; i++) {
            wordDict.add(strings[i]);
        }
        System.out.println(obj.wordBreak(s,wordDict));
    }
}