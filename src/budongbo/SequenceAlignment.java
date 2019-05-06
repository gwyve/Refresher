package budongbo;

public class SequenceAlignment {

    public int align(String s,String t){
        int[][] tmp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < s.length()+1; i++) {
            tmp[i][0] = -3*i;
        }
        for (int i = 0; i < t.length()+1; i++) {
            tmp[0][i] = -3*i;
        }

        for (int i = 1; i < t.length()+1; i++) {
            for (int j = 1; j < s.length()+1; j++) {
                // 第一个opt（i-1,j-1）
                int a = tmp[j-1][i-1];
                // 字符串是从0开始的
                if (s.charAt(j-1) == t.charAt(i-1))
                    a = a + 1;
                else
                    a = a - 1;
                //第二个opt
                int b = tmp[j-1][i] -3;
                //第三个opt
                int c = tmp[j][i-1] -3;

                int max = a;
                if (b>max)
                    max = b;
                if (c>max)
                    max = c;
                tmp[j][i] = max;
            }
        }

        for (int i = 0; i < t.length()+1; i++) {
            for (int j = 0; j < s.length()+1; j++) {
                System.out.print(tmp[j][i] + "  ");
            }
            System.out.println();
        }


        return tmp[s.length()][t.length()];

    }



    public static void main(String[] args){
        SequenceAlignment obj = new SequenceAlignment();
        System.out.println(obj.align("OCURRANCE","OCCURRENCE"));

    }
}