package OJ.LeetCode.Num201_250;

import java.util.Stack;

public class Num224BasicCalculator {

    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                int sum = s.charAt(i) - '0';
                while (i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    sum = sum * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                result += sum * sign;
            }else if (s.charAt(i) == '+'){
                sign = 1;
            }else if (s.charAt(i) == '-'){
                sign = -1;
            }else if (s.charAt(i) == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }else if (s.charAt(i) == ')'){
                result = stack.pop()* result + stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args){
        Num224BasicCalculator obj = new Num224BasicCalculator();
        System.out.println(obj.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}