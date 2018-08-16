package javaCode.algs.sort;

import edu.princeton.cs.algs4.MergeBU;
import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);

        if (alg.equals("Shell"))     Shell.sort(a);
        if (alg.equals("Shell2"))    edu.princeton.cs.algs4.Shell.sort(a);

        if (alg.equals("MergeX")) MergeBU.sort(a);
        if (alg.equals("MergeSortX"))   MergeSortBU.sort(a);
        if (isSorted(a))
            return timer.elapsedTime();
        else
            return -100;
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j)  < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String alg1 = "Insertion";
//        String alg2 = "Selection";
//        String alg3 = "Shell";
//        String alg4 = "Shell2";

        String alg5 = "MergeX";
        String alg6 = "MergeSortX";
        int N = 1000;
        int T = 10;
//        double t1 = timeRandomInput(alg1, N, T);
//        double t2 = timeRandomInput(alg2, N, T);
//        double t3 = timeRandomInput(alg3, N, T);
//        double t4 = timeRandomInput(alg4, N, T);

        double t5 = timeRandomInput(alg5, N, T);
        double t6 = timeRandomInput(alg6, N, T);

//        System.out.printf("%s = %.4f\n", alg1, t1);
//        System.out.printf("%s = %.4f\n", alg2, t2);
//        System.out.printf("%s = %.4f\n", alg3, t3);
//        System.out.printf("%s = %.4f\n", alg4, t4);
        System.out.printf("%s = %.4f\n", alg5, t5);
        System.out.printf("%s = %.4f\n", alg6, t6);


//        System.out.printf("%s is %.1f times faster than %s\n", alg2, t1 / t2, alg1);
//        System.out.printf("%s is %.1f times faster than %s\n", alg3, t1 / t3, alg1);
    }
}
