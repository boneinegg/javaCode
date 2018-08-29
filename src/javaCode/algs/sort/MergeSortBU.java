package javaCode.algs.sort;

import java.util.Comparator;
import java.util.Scanner;

public class MergeSortBU {
    private static Comparable[] aux;

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len+len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo+len+len-1, n-1);
                merge(a, aux, lo, mid, hi);
            }
        }
        assert isSorted(a, 0, n-1);
    }


    //辅助函数
    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean less(Comparable v, Comparable w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    public static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);;
    }

    //测试
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] src = scanner.useDelimiter("\\n").next().split(" ");
        sort(src);
        show(src);
    }
}
