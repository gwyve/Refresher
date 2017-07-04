package OJ.LeetCode.Num051_100;

/**
 * Created by VE on 2017/7/4.
 */
public class Num058LengthofLastWord {

    public int lengthOfLastWord(String s){
        int ret = 0;
        boolean isLast = false;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
                if (isLast)
                    return ret;
            }else{
                isLast = true;
                ret ++;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        Num058LengthofLastWord obj = new Num058LengthofLastWord();
        System.out.println(obj.lengthOfLastWord("Hello world"));
    }
}
