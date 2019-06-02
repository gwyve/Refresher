package OJ.LeetCode.Num101_150;

import java.util.Stack;

public class Num150EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            Integer cur = null;
            try {
                cur = Integer.parseInt(tokens[i]);
            }catch (Exception e){

            }
            if (cur != null){
                stack.add(cur);
            }else {
                int b = stack.pop();
                int a = stack.pop();
                if (tokens[i].equals("+")){
                    stack.push(a+b);
                }else if (tokens[i].equals("-")){
                    stack.push(a - b);
                }else if (tokens[i].equals("*")){
                    stack.push(a * b);
                }else if (tokens[i].equals("/")){
                    stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        Num150EvaluateReversePolishNotation obj = new Num150EvaluateReversePolishNotation();
        System.out.println(obj.evalRPN(new String[] {"2","1","+","3","*"}));
    }
}
