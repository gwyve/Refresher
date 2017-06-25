package OJ.LeetCode.Num001_050;

/**
 * Created by VE on 2017/2/8.
 */
public class Num014LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0)
            return "";

        String ret = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(ret) != 0){
                ret = ret.substring(0,ret.length()-1);
            }
            i++;
        }


        return ret;


    }


    public static void main(String args[]){
        Num014LongestCommonPrefix obj = new Num014LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(new String[]{"abc","abc","abcdes","ab","abcd"}));
    }
}
