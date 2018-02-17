package OJ.LeetCode.Num051_100;

/**
 * Created by yixina-z on 18/2/17.
 */
public class Num096UniqueBinarySearchTrees {
    public int numTrees(int n){
        int[] tmp = new int[n+1];
        if (n < 3)
            return n;
        tmp[0] = 1;
        tmp[1] = 1;
        tmp[2] = 2;
        for (int i = 3; i <= n ; i++) {
            int t = 0;
            for (int j = 0; j < i; j++) {
                t += tmp[j] * tmp[i-j-1];
            }
            tmp[i] = t;

        }
        return tmp[n];

    }


    public static void main(String[] args){
        Num096UniqueBinarySearchTrees obj = new Num096UniqueBinarySearchTrees();
        System.out.println(obj.numTrees(19));
    }
}
