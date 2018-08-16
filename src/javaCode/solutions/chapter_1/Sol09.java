package javaCode.solutions.chapter_1;

public class Sol09 {

    public static void main(String[] args) {
        String s = "";
        int N = 0;
        if (N == 0) s = "0";
        for (int n = N; n > 0; n /= 2) {
            s = n % 2 + s;
        }
        String s2 = Integer.toBinaryString(N);
        System.out.println(s);
        System.out.println(s2);

    }
}
