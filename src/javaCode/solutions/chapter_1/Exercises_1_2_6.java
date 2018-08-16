package javaCode.solutions.chapter_1;

public class Exercises_1_2_6 {

    //1_2_7
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";
        if (s.length() == t.length() && s.concat(s).indexOf(t) > 0)
            System.out.println("true");
        else
            System.out.println("false");

        String string = "To be or not to be";
        String[] ret = string.split(" ");
        for (int i = 0; i < ret.length; i++)
            System.out.print(mystery(ret[i]) + " ");
    }

}
