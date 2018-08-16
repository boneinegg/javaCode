package javaCode.algs.sort;

import java.util.Comparator;
import java.util.Scanner;

public class MergeSortX {
    //小数组切换成插入排序
    private static int CUTOFF = 7;

    private MergeSortX() {  }

    private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
        assert isSorted(src, lo, mid);
        assert isSorted(src, mid+1, hi);

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              dst[k] = src[j++];
            else if (j > hi)               dst[k] = src[i++];
            else if (less(src[j], src[i])) dst[k] = src[j++];   // to ensure stability
            else                           dst[k] = src[i++];
        }

        // postcondition: dst[lo .. hi] is sorted subarray
        assert isSorted(dst, lo, hi);
    }

    public static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid+1, hi);
        if (!less(src[mid+1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(src, dst, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length-1);
        assert isSorted(a, 0, a.length-1) : "yes";
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
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
