package OJ.LeetCode.Num001_050;

public class Num005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        String maxString = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            String tmp = searchPalindromic(s,i,i);
            if (tmp.length() > maxString.length())
                maxString = tmp;
            tmp = searchPalindromic(s,i,i+1);
            if (tmp.length() > maxString.length())
                maxString = tmp;
        }
        return maxString;
    }

    public String searchPalindromic(String s,int left,int right){
        // 此处想明白边界问题
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        return s.substring(left+1,right );
    }

    public static void main(String[] args){

        Num005LongestPalindromicSubstring obj = new Num005LongestPalindromicSubstring();
        System.out.println(obj.longestPalindrome("abcde"));
    }

}