package OJ.LeetCode.Num051_100;

public class Num097InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        // 三个字符串仍然由两个字符串构建一个dp的图
        // 这种题最好一开始就放弃递归，否则真的是超时
        if (s3 == null && (s1==null || s2 == null))
            return false;
        if (s1.length()+s2.length()!=s3.length())
            return false;
        boolean[][] map = new boolean[s1.length()+1][s2.length()+1];
        map[0][0] = true;
        for (int i = 0; i < s1.length()+1; i++) {
            for (int j = 0; j < s2.length()+1; j++) {
                if (i == 0 && j != 0){
                    map[i][j] =  map[i][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
                }else if (j == 0 && i!=0 ){
                    map[i][j] =  map[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1);
                }else if(i!=0 && j!=0){
                    map[i][j] = (map[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1))||(map[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1));
                }
            }
        }
        return map[s1.length()][s2.length()];

    }



    public static void main(String[] args){
        Num097InterleavingString obj = new Num097InterleavingString();
        System.out.println(obj.isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(obj.isInterleave("aabcc","dbbca", "aadbbbaccc"));
    }
}