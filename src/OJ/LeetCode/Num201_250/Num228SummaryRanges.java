package OJ.LeetCode.Num201_250;

import java.util.ArrayList;
import java.util.List;

public class Num228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while (i<nums.length){
            boolean flag = true;
            int begin = nums[i];
            int end = nums[i];
            int j = 0;
            while (flag ){
                j ++;
                if (i+j == nums.length){
                    i = i+j;
                    if (begin == end)
                        ret.add(""+begin);
                    else
                        ret.add(begin+"->"+end);
                }else if (i+j > nums.length){
                    flag = false;
                    i = nums.length;
                }else if (begin + j == nums[i+j]){
                    end = begin + j;
                }else if (begin == end){
                    ret.add(begin+"");
                    begin = nums[i+j];
                    end = nums[i+j];
                    i = i + j;
                    flag = false;
                }else if (begin != end){
                    ret.add(begin+"->"+end);
                    begin = nums[i+j];
                    end = nums[i+j];
                    i = i+j;
                    flag = false;
                }
            }
        }
        return ret;
    }
    public static void main(String[] args){
        Num228SummaryRanges obj = new Num228SummaryRanges();
        System.out.println(obj.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}