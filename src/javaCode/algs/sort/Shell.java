package javaCode.algs.sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Shell {
    private Shell() {   }

    public static void sort(Comparable[] a) {
        int h = 1;
        int N = a.length;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j-=h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
        assert isSorted(a);
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j)  < 0;
    }

    public static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int N = 100;
        Double[] d = new Double[N];
        for (int i = 0; i < N; i++)
            d[i] = StdRandom.uniform();
        System.out.println(isSorted(d));
        sort(d);
        System.out.println(isSorted(d));
//        show(d);

//        String[] a = StdIn.readAllStrings();
//        Arrays.sort(a);
//        sort(a);
//        isSorted(a);
//        show(a);
    }
}
