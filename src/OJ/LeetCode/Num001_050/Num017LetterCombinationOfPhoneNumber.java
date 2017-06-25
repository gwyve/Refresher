package OJ.LeetCode.Num001_050;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by VE on 2017/2/17.
 */
public class Num017LetterCombinationOfPhoneNumber {
    //这个题，我的想法基本属于很复杂的那种，

    public List<String> letterCombinations(String digits) {

        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() != 0)
            ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();  //这个是我觉得最神奇的地方~
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

    public static void main(String[] args){

    }

}
