package OJ.LeetCode.Num051_100;

public class Num076MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        // 这个题的解法是：https://blog.csdn.net/EveryFriDay_ShuJk/article/details/80072583

        // 这个解法中，map[]中只有在t中存在的字符才可能为正数，否则一直都非负数。
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)] ++;
        }
        int count = t.length();
        int begin = 0;
        int end = 0;
        int head = 0;
        int d = Integer.MAX_VALUE;

        while (end < s.length()){
            if (map[s.charAt(end)]>0){
                count --;
            }
            map[s.charAt(end)] --;
            end++;
            while (count == 0){
                if (d > end-begin){
                    d = end - begin;
                    head = begin;
                }

                // 这个如果为负数的时候可能是窗口中另外包含一个该字符
                if (map[s.charAt(begin)] == 0){
                    count++;
                }
                map[s.charAt(begin)]++;
                begin++;
            }
        }
        return d==Integer.MAX_VALUE?"":s.substring(head,head+d);

    }


    public static void main(String[] args){
        Num076MinimumWindowSubstring obj = new Num076MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC","ABC"));

    }
}