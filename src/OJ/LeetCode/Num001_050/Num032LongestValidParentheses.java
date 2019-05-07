package OJ.LeetCode.Num001_050;

import java.util.Stack;

public class Num032LongestValidParentheses {

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
        System.out.println(obj.longestValidParentheses("()(())"));
    }
}