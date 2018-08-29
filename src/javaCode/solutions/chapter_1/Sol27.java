package javaCode.solutions.chapter_1;

/**
Binomial distribution. Estimate the number of recursive calls that would be used
 by the method call binomial1(100, 50, .25) in Binomial.java. Develop a better
 implementation that is based on saving computed values in an array.
*/
public class Sol27 {
    //slow
    public static double binomial1(int N, int k, double p) {
        if (N == 0 && k == 0)   return 1.0;
        if (N < 0 || k < 0)     return 0.0;
        return (1.0 - p) * binomial1(N-1, k, p) + p * binomial1(N-1, k-1, p);
    }

    public static double binomial2(int N, int k, double p) {
        double[][] b = new double[N+1][k+1];

        for (int i = 0; i < N; i++)
            b[i][0] = Math.pow(1.0 - p, i);
        b[0][0] = 1.0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                b[i][j] = p * b[i-1][j-1] + (1.0 - p) * b[i-1][j];
            }
        }
        return b[N][k];
    }

    public static void main(String[] args) {
        System.out.println(binomial1(100, 50, 0.25));
        System.out.println(binomial2(100, 50, 0.25));

    }
}
