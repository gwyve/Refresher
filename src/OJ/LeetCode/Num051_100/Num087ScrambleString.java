package OJ.LeetCode.Num051_100;

public class Num087ScrambleString {

    public boolean isScramble(String s1, String s2) {
        if (s1.length()!=s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        // 如果只需要判断字母内容，而不用判断字母顺序就可以用这个map的方法
        int[] map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)-'a'] ++;
        }
        for (int i = 0; i < s2.length(); i++) {
            map[s2.charAt(i)-'a'] --;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0)
                return false;
        }
        // 此处应该是1开始。
        for (int i = 1; i < s1.length(); i++) {
            if ( (isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
                    // 这个地方需要想明白具体子字符串的样子
                    || (isScramble(s1.substring(0,s1.length()-i),s2.substring(i)) && isScramble(s1.substring(s2.length()-i),s2.substring(0,i))) )
                return true;
        }

        return false;

    }


    public static void main(String[] args){
        Num087ScrambleString obj = new Num087ScrambleString();
        System.out.println(obj.isScramble("abb","bba"));
    }


}