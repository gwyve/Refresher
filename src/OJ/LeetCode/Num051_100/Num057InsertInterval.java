package OJ.LeetCode.Num051_100;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by VE on 2017/6/28.
 */
public class Num057InsertInterval {
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
    public List<Interval>  insert(List<Interval> intervals, Interval newInterval){
//        这个题目的是建立在没有重叠的基础之上的
//        针对如果intervals里面的iterm比newInterval小的话，添加进入iterm
        List<Interval> retList = new LinkedList<Interval>();
        for (Interval i : intervals){
            if (newInterval == null || i.end < newInterval.start){
                retList.add(i);
            }else if (i.start > newInterval.end){
//                这个是属于newInterval比i的不重叠还靠后
                retList.add(newInterval);
                retList.add(i);
                newInterval = null;
            }else {
//                这个情况就是属于有重叠的情况
                newInterval.start = Math.min(i.start,newInterval.start);
                newInterval.end = Math.max(i.end,newInterval.end);
            }
        }
        if (newInterval!= null)
            retList.add(newInterval);

        return retList;
    }
}
