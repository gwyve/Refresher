package OJ.LeetCode.Num001_050;

import java.util.Stack;

/**
 * Created by VE on 2017/4/5.
 */
public class Num020ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> par = new Stack<Character>();
        for (int i= 0; i<s.length();i++){
            switch (s.charAt(i)){
                case '{':
                case '[':
                case '(':
                    par.push(s.charAt(i));
                    break;
                case '}':
                    if (!par.isEmpty() && par.pop() == '{')
                        continue;
                    else
                        return false;
                case ')':
                    if (!par.isEmpty() && par.pop() == '(')
                        continue;
                    else
                        return false;
                case ']':
                    if (!par.isEmpty() && par.pop() == '[')
                        continue;
                    else
                        return false;
            }


        }
        if (par.isEmpty())  //这个判断很重要！！！
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        Num020ValidParentheses obj = new Num020ValidParentheses();
        System.out.println(obj.isValid("{}{}[]"));
    }
}
