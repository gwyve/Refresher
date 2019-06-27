package OJ.LeetCode.Num201_250;

public class Num214ShortestPalindrome {

    public String shortestPalindrome(String s) {
        // 虽然通过了，但是速度太慢了
        if (s ==null || s.length()==0 || s.length()==1)
            return s;
        int end = -1;
        for (int i = 0; i < s.length(); i++) {
            int left = 0;
            int right = i;
            while (s.charAt(left) == s.charAt(right)){
                if (left == right || right - left == 1){
                    end = i;
                    break;
                }
                left++;
                right--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >end ; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }


    public static void main(String[] args){
        Num214ShortestPalindrome obj = new Num214ShortestPalindrome();
        System.out.println(obj.shortestPalindrome("abbacd"));
    }



}