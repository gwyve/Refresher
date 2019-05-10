package OJ.LeetCode.Num051_100;

public class Num065ValidNumber {
    public boolean isNumber(String s){
        // 这个第一次用转移矩阵做题，用状态机的方法；
        // 这个里面需要注意的合并很多个状态，这个是重点
        int[][] trans =  new int[][]{
                {-1, 0, 1, 2, 3,-1},
                {-1,-1,-1, 2, 3,-1},
                {-1, 4,-1, 2, 6, 5},
                {-1,-1,-1, 6,-1,-1},
                {-1, 4,-1,-1,-1,-1},
                {-1,-1, 7, 8,-1,-1},
                {-1, 4,-1, 6,-1, 5},
                {-1,-1,-1, 8,-1,-1},
                {-1, 4,-1, 8,-1,-1}
        };
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            int type;
            if (s.charAt(i)>='0' && s.charAt(i)<='9'){
                type = 3;
            }else if (s.charAt(i) == ' '){
                type = 1;
            }else if (s.charAt(i) == '+' || s.charAt(i) == '-'){
                type = 2;
            }else if (s.charAt(i) == 'E' || s.charAt(i) == 'e'){
                type = 5;
            }else if (s.charAt(i) == '.'){
                type = 4;
            }else {
                type = 0;
            }
            state = trans[state][type];
            if (state == -1)
                return false;
        }
        return state == 2 || state == 4 || state == 6 || state == 8;


    }



    public static void main(String[] args){
        Num065ValidNumber obj = new Num065ValidNumber();

        System.out.println(obj.isNumber(" 005047e+6"));
    }
}