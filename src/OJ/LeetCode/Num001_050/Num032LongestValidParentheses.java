package OJ.LeetCode.Num001_050;

import java.util.Stack;

public class Num032LongestValidParentheses {


    public int longestValidParenthesesDP(String s){
        // 这个的规律，只是感觉根据子字符串的长度，找到对称的那块内容的。
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i <s.length() ; i++) {
            if(s.charAt(i)==')')
            {
                if(i-1>=0 && i-(1+dp[i-1]) >=0 &&
                        // 这个是重点
                        s.charAt(i-(1+dp[i-1]))=='(')
                {
                    dp[i]=dp[i-1]+2;
                    // 以下内容是用来判断当前添加左侧‘（’，之前的子字符串的长度。如果两个都是最佳则连起来。
                    if (i-dp[i] > 0)
                        dp[i]+=dp[i-dp[i]];
                }
            }
            // 每次都更新最大子字符串长度
            res = res>dp[i] ? res:dp[i];
        }
        return res;
    }



    public int longestValidParentheses(String s) {
        int res = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                if (stack.empty()){
                    start = i+1;
                }else {
                    stack.pop();
                    if (stack.empty()){
                        res = res > i-start+1 ? res:i-start+1;
                    }else {
                        // 只有这个时候才是配对成功的时候，只有这个时候才能计算长度
                        // 这里应该是peek，而不是pop
                        int pop = stack.peek();
                        res = res > i-pop ? res : i-pop;
                    }
                }
            }
        }
        return res;

    }

    public static void main(String[] args){
        Num032LongestValidParentheses obj = new Num032LongestValidParentheses();
        System.out.println(obj.longestValidParenthesesDP("())"));
    }
}