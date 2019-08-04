package OJ.LeetCode.Num201_250;

import java.util.Stack;

public class Num227BasicCalculatorII {
    public int calculate(String s) {
        // 这个虽然ac了，不过速度确实挺慢的
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Character> op = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                int sum = s.charAt(i) - '0';
                while (i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    sum = sum * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                if (op.empty()){
                    stack.push(sum);
                }else if (op.peek() == '*' ){
                    stack.push(stack.pop() * sum);
                    op.pop();
                }else if (op.peek() == '/'){
                    stack.push(stack.pop() / sum);
                    op.pop();
                }else {
                    stack.push(sum);
                }
            }else if (s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == '/' || s.charAt(i) == '*'){
                op.push(s.charAt(i));
            }
        }

        int result = 0;
        while (!stack.empty()){
            if (!op.empty() && op.pop() == '-'){
                result = result - stack.pop();
            }else {
                result = result + stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args){
        Num227BasicCalculatorII obj = new Num227BasicCalculatorII();
        System.out.println(obj.calculate("42"));
    }
}