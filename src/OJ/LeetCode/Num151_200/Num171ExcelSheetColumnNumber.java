package OJ.LeetCode.Num151_200;

public class Num171ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        char t = 'A' -1;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26;
            res = res + s.charAt(i) - t;
        }
        return res;
    }
    public static void main(String[] args){
        Num171ExcelSheetColumnNumber obj = new Num171ExcelSheetColumnNumber();
        System.out.println(obj.titleToNumber("AA"));
    }
}