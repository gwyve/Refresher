package OJ.LeetCode.Num101_150;

public class Num125ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (true){
            if (j<i)
                return true;
            if (s.charAt(i)>='a' && s.charAt(i)<='z'){
                if (s.charAt(j)>='a' && s.charAt(j) <='z'){
                    if ((s.charAt(i) - s.charAt(j)) != 0){
                        return false;
                    }else {
                        i++;
                        j--;
                    }
                }else if (s.charAt(j)>='A' && s.charAt(j)<='Z'){
                    if ((s.charAt(i)-s.charAt(j))!=('a'-'A')){
                        return false;
                    }else {
                        i++;
                        j--;
                    }
                }else if (s.charAt(j)>='0' && s.charAt(j)<='9'){
                    return false;
                }else {
                    j--;
                }
            }else if (s.charAt(i)>='A' && s.charAt(i)<='Z' ){
                if (s.charAt(j)>='a' && s.charAt(j) <='z'){
                    if ((s.charAt(i) - s.charAt(j)) != ('A'-'a')){
                        return false;
                    }else {
                        i++;
                        j--;
                    }
                }else if (s.charAt(j)>='A' && s.charAt(j)<='Z'){
                    if ((s.charAt(i)-s.charAt(j))!=0){
                        return false;
                    }else {
                        i++;
                        j--;
                    }
                }else if (s.charAt(j)>='0' && s.charAt(j)<='9'){
                    return false;
                }else {
                    j--;
                }
            }else if (s.charAt(i)>='0' && s.charAt(i)<='9'){
                if (s.charAt(j)>='0' && s.charAt(j) <='9'){
                    if (s.charAt(i)!=s.charAt(j)){
                        return false;
                    }else {
                        i++;
                        j--;
                    }
                }else if ((s.charAt(j)>='a' && s.charAt(j)<='z') || (s.charAt(j)>='A'&&s.charAt(j)<='Z')){
                    return false;
                }else {
                    j--;
                }
            }else{
                i++;
            }
        }
    }

    public static void main(String[] args){
        Num125ValidPalindrome obj = new Num125ValidPalindrome();
        System.out.println(obj.isPalindrome("P0P"));
    }

}