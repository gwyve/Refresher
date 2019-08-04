package OJ.LeetCode.Num201_250;

public class Num223RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s1 = (C-A) * (D-B);
        int s2 = (G-E) * (H-F);

        int left = Math.max(A,E);
        int right = Math.min(C,G);
        long l = right - (long)left;

        int bottom = Math.max(B,F);
        int top = Math.min(D,H);
        long h = top - (long)bottom;

        if (l>0 && h> 0)
            return s1+ s2 - (int)(l*h);
        else
            return s1+s2;
    }

    public static void main(String[] args){
        Num223RectangleArea obj = new Num223RectangleArea();
//        System.out.println(obj.computeArea(-3,0,3,4,0,-1,9, 2));
        System.out.println(obj.computeArea(-1500000001,                0,            -1500000000,           1,           1500000000,        0,         1500000001,         1));
    }
}