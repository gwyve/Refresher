package OJ.LeetCode.Num051_100;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by VE on 2017/6/27.
 */
public class Num054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ret = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ret;
        int start = 0;
        while (2*start < matrix.length && 2*start <matrix[0].length){
            ret.addAll(circlePrint(start,matrix));
            start ++;
        }
        return ret;
    }

    private List<Integer> circlePrint(int start,int[][] matrix){
        List<Integer> circleList = new LinkedList<Integer>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = start; i < cols-start; i++) {
            circleList.add(matrix[start][i]);
        }

        for (int i = start + 1;i < rows - start;i++){
            circleList.add(matrix[i][cols-start-1]);
        }
        if (start < rows/2){
            for (int i = cols-start-2;i >= start;i--){
                circleList.add(matrix[rows-start-1][i]);
            }
        }

        if (start<cols/2){
            for (int i = rows-start-2; i >start ; i--) {
                circleList.add(matrix[i][start]);
            }
        }

        return circleList;
    }


    public static void main(String[] args){
        Num054SpiralMatrix obj = new Num054SpiralMatrix();
        List<Integer> ret = obj.spiralOrder(new int[][]{{1,2}});
        for (int i = 0; i < ret.size(); i++) {
            System.out.print(ret.get(i)+" ");
        }
    }
}
