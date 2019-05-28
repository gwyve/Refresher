package OJ.LeetCode.Num101_150;

public class Num135Candy {

    public int candy(int[] ratings) {
        // 这个题，往返三次循环
        // 重点在于第三次，从大道小的问题

        int res = 0;
        int[] candy = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            candy[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i-1] < ratings[i]){
                candy[i] = candy[i-1] + 1;
            }
        }
        for (int i = ratings.length-2; i >=0; i--) {
            // 这个位置是重点 && 符号之后的问题
            if ((ratings[i]>ratings[i+1]) && (candy[i] <= candy[i+1])){
                candy[i] = candy[i+1] + 1;
            }
        }

        for (int i = 0; i < candy.length; i++) {
            res+=candy[i];
            System.out.print(candy[i] + " ");
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args){
        Num135Candy obj = new Num135Candy();
        System.out.println(obj.candy(new int[]{1,2,87,87,87,2,1}));
//        System.out.println(obj.candy(new int[]{1,0,2}));
    }
}