package OJ.LeetCode.Num201_250;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num210CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for (int[] edge:prerequisites){
            inDegree[edge[0]] ++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        int index = 0;
        while (!queue.isEmpty()){
            int tmp = queue.poll();
            res.add(tmp);
            index++;
            for (int[] edge:prerequisites){
                if (tmp == edge[1]){
                    inDegree[edge[0]] --;
                    if (inDegree[edge[0]] == 0)
                        queue.add(edge[0]);
                }
            }
        }
        if (res.size() == numCourses){
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = res.get(i);
            }
            return ret;
        }else {
            return new int[0];
        }
    }

    public static void main(String[] args){
        Num210CourseScheduleII obj = new Num210CourseScheduleII();
        int[] res = obj.findOrder(3,new int[][]{{1,0},{2,1}});
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}