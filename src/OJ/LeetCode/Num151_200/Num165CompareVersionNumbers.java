package OJ.LeetCode.Num151_200;

public class Num165CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0)
            return 0;
        String[] verStrs1 = version1.split("\\.");
        String[] verStrs2 = version2.split("\\.");
        if (verStrs1.length == 0)
            verStrs1 = new String[]{version1};
        if (verStrs2.length == 0)
            verStrs2 = new String[]{version2};
        int len1 = verStrs1.length;
        int len2 = verStrs2.length;
        int len = len1<len2?len1:len2;

        for (int i = 0; i < len; i++) {
            int v1 = Integer.valueOf(verStrs1[i]);
            int v2 = Integer.valueOf(verStrs2[i]);
            if (v1 == v2)
                continue;
            if (v1>v2)
                return 1;
            if (v1<v2)
                return -1;
        }
        if (len1>len){
            for (int i = len; i < len1; i++) {
                if (Integer.valueOf(verStrs1[i])>0)
                    return 1;
            }
        }
        if (len2>len){
            for (int i = len; i < len2; i++) {
                if (Integer.valueOf(verStrs2[i])>0)
                    return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        Num165CompareVersionNumbers obj = new Num165CompareVersionNumbers();
        System.out.println(obj.compareVersion("1","1.1"));
    }
}