package SwordPointOffer;

/**
 * Created by VE on 2017/3/15.
 */
public class Num020PrintMatrix {

    public void PrintMatrixClockwisely(int[][] data){
        if (data == null || data.length == 0)
            return;
        if (data[0].length == 0)
            return;
        int rows = data.length;
        int columns = data[0].length;

        int start = 0;
        while(rows > start *2 && columns > start * 2){
            PrintMatrixInCircle(data,columns,rows,start);
            start ++;
        }
    }

    private void PrintMatrixInCircle(int[][] data,int columns,int rows,int start){
        int endX = columns - start - 1;
        int endY = rows - start -1;

        for (int i = start;i<=endX;i++){
            print(data[start][i]);
        }
        if (start < endY){ //以下对这个行列数的判断很重要
            for (int i= start + 1; i<= endY;i++){ //这个加一容易遗忘
                print(data[i][endX]);
            }
        }
        if (start < endX && start <endY){
            for (int i = endX -1; i >= start ; i--) {
                print(data[endY][i]);
            }
        }
        if (start < endX && start < endY){
            for (int i = endY -1 ; i > start ; i--) {
                print(data[i][start]);
            }
        }
    }

    private void print(int data){
        System.out.print(data+" ");
    }


    public static void main(String args[]){
        int[][] data = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        Num020PrintMatrix obj = new Num020PrintMatrix();
        obj.PrintMatrixClockwisely(data);
    }
}
