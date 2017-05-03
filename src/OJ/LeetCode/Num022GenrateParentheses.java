package OJ.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VE on 2017/4/5.
 */
public class Num022GenrateParentheses {

    //每增加一个数，就意味着添加了两个括号
    public List<String> generateParenthesis(int n) {
       if (n<1)
           return null;
        List<String> ret = new ArrayList<String>();
        addParenese(ret, "", 0, 0, n);
        return ret;
    }

    private void addParenese(List<String> list,String str,int left,int right,int max){
        if (str.length() == max*2){
            list.add(str);
            return;
        }

        if (left < max){
            addParenese(list,str + "(",left+1,right,max);
        }
        if (right < left){
            addParenese(list,str+")",left,right + 1,max);
        }
    }

    public  static void main(String[] args){
        Num022GenrateParentheses obj = new Num022GenrateParentheses();
        System.out.println(obj.generateParenthesis(2));
    }
}
