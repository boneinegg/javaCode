package javaCode.solutions.chapter_1;

public class Sol15_16_17_18_19_20 {
    public static int count(int[] a, int k) {
        int n = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == k) n++;
        return n;
    }

    public static int[] histogram(int[] a, int M) {
        int[] result = new int[M];
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0 && a[i] < M) {
                result[a[i]]++;
            }
        }
        for (int i = 0; i < M; i++)
            System.out.println(result[i]);
        return result;
    }

    public static int[] histogram2(int[] a, int M) {
        int[] ret = new int[M];
        for (int i = 0; i < M; i++) {
            ret[i] = count(a, i);
            System.out.println(ret[i]);
        }
//        System.out.println();
        return ret;
    }

    //16
    public static String exR1(int n)
    {
        if (n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    //18
    public static int mystery(int a, int b)
    {
        if (b == 0)
            return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }

    public static int mystery2(int a, int b)
    {
        if (b == 0)
            return 1;
        if (b % 2 == 0) return mystery(a*a, b/2);
        return mystery(a*a, b/2) * a;
    }

    //20

    public static double lnFactorial(int N) {
        if (N == 1) return 0;
        return Math.log(N) + lnFactorial(N - 1);
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 2, 1, 0, 1, 1, 3};
        int M = 3;
        histogram2(test, M);
//        System.out.println(exR1(3));
//        System.out.println(mystery(2, 25));
//        System.out.println(mystery2(2, 25));
//        System.out.println(Math.pow(2, 25));
        System.out.println(lnFactorial(3));
        System.out.println(Math.log(6));
    }
}
