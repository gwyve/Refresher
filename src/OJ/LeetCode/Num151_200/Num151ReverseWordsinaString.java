package OJ.LeetCode.Num151_200;

public class Num151ReverseWordsinaString {
    public String reverseWords(String s) {
        // 设置一个end作为标志
        if (s==null || s.length() ==0)
            return s;
        if (s.length() == 1){
            if (s.charAt(0) == ' ')
                return "";
            else
                return s;
        }
        StringBuilder sb = new StringBuilder();
        int end = -1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (end == -1){
                if (i==s.length()-1){
                    if (s.charAt(i)==' ' && s.charAt(i-1) != ' '){
                        end = i;
                    }else if (s.charAt(i)!=' '){
                        end = i+1;
                    }
                }else {
                    if (s.charAt(i+1) == ' ' && s.charAt(i)!=' '){
                        end = i+1;
                    }
                }
            }else {
                if (i==0){
                    // 这里是i+1还是i-1要与上面的那个对应，否则报错
                    if (s.charAt(i) == ' '&& s.charAt(i+1)!=' '){
                        if (sb.length()!=0)
                            sb.append(" ");
                        sb.append(s.substring(i+1,end));
                        end = -1;
                    }
                }else if (i<s.length()-1){
                    if (s.charAt(i+1) != ' ' && s.charAt(i) == ' '){
                        if (sb.length()!=0)
                            sb.append(" ");
                        sb.append(s.substring(i+1,end));
                        end = -1;
                    }
                }
            }
        }
        if (end!=-1){
            if (sb.length()!=0){
                sb.append(" ");
            }
            sb.append(s.substring(0,end));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Num151ReverseWordsinaString obj = new Num151ReverseWordsinaString();
        System.out.println("||"+obj.reverseWords(" a dfdsfs          ")+"||");

    }
}