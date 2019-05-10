package OJ.LeetCode.Num051_100;

import java.util.ArrayList;
import java.util.List;

public class Num068TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        // 这个方法虽然也能做，但是，自我感觉太笨了
        List<String> res = new ArrayList<String>();

        List<String> tmp = new ArrayList<String>();
        int tmpLength = 0;
        for (int i = 0; i < words.length; i++) {
            if (tmp.size() == 0){
                tmp.add(words[i]);
                tmpLength += words[i].length();
            }else {
                if (tmpLength+ tmp.size()+words[i].length() > maxWidth){
                    res.add(helper(tmp,tmpLength,maxWidth));

                    tmp.clear();
                    tmp.add(words[i]);
                    tmpLength = words[i].length();
                }else {
                    tmp.add(words[i]);
                    tmpLength = tmpLength + words[i].length();
                }
            }
        }
        res.add(endHelper(tmp, maxWidth));
        return res;
    }

    public String endHelper(List<String> list,int maxWidth){
        StringBuilder sb = new StringBuilder(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append(" ");
            sb.append(list.get(i));
        }
        for (int i = sb.length(); i < maxWidth; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }


    public String helper(List<String> list,int wordLength, int maxWidth){
        if (list.size()==1){
            StringBuilder sb = new StringBuilder(list.get(0));
            for (int i = sb.length(); i < maxWidth; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        int spaceRemain = (maxWidth-wordLength)%(list.size()-1);
        int tmp = (maxWidth-wordLength)/(list.size()-1);

        StringBuilder sb = new StringBuilder(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < tmp; j++) {
                sb.append(" ");
            }
            if (spaceRemain>0){
                sb.append(" ");
                spaceRemain--;
            }
            sb.append(list.get(i));
        }

        return sb.toString();
    }


    public static void main(String[] args){
        Num068TextJustification obj = new Num068TextJustification();
        System.out.println(obj.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16));
    }
}