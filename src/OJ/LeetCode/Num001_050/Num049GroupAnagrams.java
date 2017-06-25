package OJ.LeetCode.Num001_050;

import java.util.*;

/**
 * Created by VE on 2017/6/25.
 */
public class Num049GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs){
        if (strs == null)
            return null;
        Map<String,List<String>> tmp = new HashMap<String,List<String>>();

        for (String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(tmp.containsKey(key)){
                tmp.get(key).add(str);
            }else {
                tmp.put(key,new ArrayList<String>());
                tmp.get(key).add(str);
            }
        }
        return new ArrayList<List<String>>(tmp.values());

    }

    public static void main(String[] args){
        Num049GroupAnagrams obj = new Num049GroupAnagrams();
        System.out.println(obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
