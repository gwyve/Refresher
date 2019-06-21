package OJ.LeetCode.Num201_250;

import java.util.*;

public class Num207CourseSchedule {











    public boolean canFinishKahn(int numCourses, int[][] prerequisites) {
        // Kahn's Algorithms:
        // 基于入度的算法
        if (numCourses<=0)
            return true;
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0)
            return true;

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]] ++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()){
            int tmp = queue.poll();
            res.add(tmp);
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == tmp){
                    inDegree[prerequisites[i][0]] --;
                    if (inDegree[prerequisites[i][0]] == 0)
                        queue.add(prerequisites[i][0]);
                }
            }
        }

        return res.size() == numCourses;

    }



//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        // 这个dfs的方法超时了，也是在意料之中
//        boolean [][] flag = new boolean[numCourses][numCourses];
//        for (int i = 0; i < prerequisites.length; i++) {
//            flag[prerequisites[i][0]][prerequisites[i][1]] = true;
//        }
//        for (int i = 0; i < numCourses; i++) {
//            if (dfs(flag,new HashSet(),i))
//                return false;
//        }
//        return true;
//    }
//    public boolean dfs(boolean[][] flag,Set set,int cur){
//        boolean res = false;
//        if (set.contains(cur))
//            return true;
//        else
//            set.add(cur);
//        boolean[] tmp = flag[cur];
//        for (int i = 0; i < tmp.length; i++) {
//            if (tmp[i]){
//                res = res | dfs(flag,set,i);
//            }
//        }
//        set.remove(cur);
//        return res;
//    }


}