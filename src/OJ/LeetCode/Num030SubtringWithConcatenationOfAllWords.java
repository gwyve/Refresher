package OJ.LeetCode;

import java.util.*;

/**
 * Created by VE on 2017/5/19.
 */
public class Num030SubtringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s,String[] words){
        List<Integer> ret = new ArrayList<Integer>();
        if (s == null || words==null || words.length == 0 )
            return ret;
        int wordLength = words[0].length();
        
        Map<String,Integer> wordMap = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i],wordMap.containsKey(words[i])?wordMap.get(words[i])+1 : 1);
        }

        for (int i = 0; i <= s.length() - wordLength * words.length; i++) {
            Map<String,Integer> copy = new HashMap<String, Integer>(wordMap);
            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i+ j*wordLength,i + j*wordLength +wordLength);
                if (copy.containsKey(str)){
                    int count = copy.get(str);
                    if (count == 1){
                        copy.remove(str);
                    }else {
                        copy.put(str,count-1);
                    }
                    if (copy.isEmpty()){
                        ret.add(i);
                        break;
                    }
                }else
                    break;
            }
        }
        
        return ret;
        
    }

    public static  void main(String[] args){
        Num030SubtringWithConcatenationOfAllWords obj = new Num030SubtringWithConcatenationOfAllWords();

    }


}
