package OJ.LeetCode;

/**
 * Created by VE on 2017/1/7.
 */

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Num003LongestSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring1(String s) {
        //只能用于26个英文字母，其他的不行
        int max = 0;
        int start = 0;
        boolean[] exist = new boolean[26];
        int[] position = new int[26];

        for (int i = 0; i <s.length();i++){
            if (exist[(int)s.charAt(i) - (int)'a']){
                for (int j =start;j <= position[(int)s.charAt(i) - (int)'a'];j++){
                    exist[(int)s.charAt(j) - (int)'a'] = false;
                }
                start = position[(int)s.charAt(i) - (int)'a'] +1;
                exist[(int)s.charAt(i) - (int)'a'] = true;
                position[(int)s.charAt(i) - (int)'a'] = i;
            }else {
                exist[(int)s.charAt(i) - (int)'a'] = true;
                position[(int)s.charAt(i) - (int)'a'] =i;
                max = max > (i - start + 1) ? max : (i - start + 1);
            }
        }

        return max;
    }


    public int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
        boolean[] flag = new boolean[256];

        int result = 0;
        int start = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char current = arr[i];
            if (flag[current]) {
                result = Math.max(result, i - start);
                for (int k = start; k < i; k++) {
                    if (arr[k] == current) {
                        start = k + 1;
                        break;
                    }
                    flag[arr[k]] = false;
                }
            } else {
                flag[current] = true;
            }
        }

        result = Math.max(arr.length - start, result);

        return result;
    }

    public static void main(String[] args){
        Num003LongestSubstringWithoutRepeatingCharacters obj = new Num003LongestSubstringWithoutRepeatingCharacters();
        int re = obj.lengthOfLongestSubstring("safdsafewafaewf13145465asfdasf");
        System.out.print(re);
    }

}
