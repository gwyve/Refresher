package OJ.LeetCode.Num151_200;

public class Num168ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        // 跟除法是一样的

        String res = "";
        while (n!=0){
            n = n -1;
            int tmp = n%26;
            res = ((char)(tmp+'A'))+ res;
            n = n/26;
        }
        return res;
    }
    public static void main(String[] args){
        Num168ExcelSheetColumnTitle obj = new Num168ExcelSheetColumnTitle();
        System.out.println(obj.convertToTitle(701));
    }
}