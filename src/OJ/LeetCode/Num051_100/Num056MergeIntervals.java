package OJ.LeetCode.Num051_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by VE on 2017/6/27.
 */
public class Num056MergeIntervals {
    private class Interval{
        int start;
        int end;
        Interval(){
            start = 0;
            end = 0;
        }
        Interval(int s,int e){
            start = s;
            end = e;
        }

    }

    public List<Interval> merge(List<Interval> intervals){
//      这个方法是一个很简单的方法，就是当之前的start比这个end还大的时候，说明新的interval需要重新隔开
        if (intervals == null)
            return intervals;
        List<Interval> retList = new LinkedList<Interval>();
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
//      这里如果用while就会超时，我并不知道是咋回事
        for (int i = 0,j=0; i < n; i++) {
            if (i == n-1 || start[i+1] > end[i]){
                retList.add(new Interval(start[j],end[i]));
                j = i +1;
            }
        }
        return retList;
    }


}

