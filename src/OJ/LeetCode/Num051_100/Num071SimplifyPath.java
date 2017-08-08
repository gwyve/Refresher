package OJ.LeetCode.Num051_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by VE on 2017/8/8.
 */
public class Num071SimplifyPath {


    public String simplifyPath(String path) {
        if (path==null)
            return null;
        String[] ss = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals("..")){
                if (stack.size()>0)
                    stack.pop();
            }else if (ss[i].equals(".") || ss[i].equals("")){

            }else {
                stack.push(ss[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            sb.insert(0, "/" + stack.pop());
        }
        if (sb.toString().equals(""))
            return "/";
        else
            return sb.toString();
    }

    public static void main(String[] args){
        Num071SimplifyPath obj = new Num071SimplifyPath();
        System.out.println(obj.simplifyPath("home/foo/.bashrc"));
    }

}
