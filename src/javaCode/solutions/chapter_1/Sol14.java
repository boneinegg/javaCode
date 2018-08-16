package javaCode.solutions.chapter_1;

public class Sol14 {
    public static int lg(int N) {
        int ret = 0, sum = 1;
        while(sum <= N) {
            sum *= 2;
            ret++;
        }
        return --ret;
    }

    public static int lg(int N, int M) {
        return (int)(Math.log(N) / Math.log(2));
    }
    public static void main(String[] args) {
        int N = 165;
        System.out.println(lg(N));
        System.out.println(lg(N, 0));
    }
}
