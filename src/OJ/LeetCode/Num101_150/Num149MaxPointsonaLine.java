package OJ.LeetCode.Num101_150;

public class Num149MaxPointsonaLine {
    public int maxPoints(int[][] points) {
        // oj竟然容忍暴力求解的方式。。。
        if (points.length<2){
            return points.length;
        }
        int res = 2;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                int count = 2;
                for (int k = 0; k < points.length; k++) {
                    if (k==i || k == j)
                        continue;
                    if (checkPoints(points[i],points[j],points[k]))
                        count++;
                }
                res = res>count?res:count;
            }
        }
        return res;
    }
    public static boolean checkPoints(int[] a,int[] b,int[] c){
        if (a[0] == b[0]){
            return a[0] == c[0];
        }else {
            return ((long)a[1]-b[1])*(a[0]-c[0]) == ((long)a[0]-b[0]) *(a[1]-c[1]);
        }
    }

    public static void main(String[] args){
        Num149MaxPointsonaLine obj = new Num149MaxPointsonaLine();
        System.out.println(obj.maxPoints(new int[][]{
                {0,0},
                {1,65536},
                {65536,1}
//                {3,2},
//                {5,3},
//                {4,1},
//                {2,3},
//                {1,4}
        }));
    }

}