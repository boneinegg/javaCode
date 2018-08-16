package javaCode.algs.sort;

import edu.princeton.cs.algs4.StdIn;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MergeSort {
    private MergeSort() {   }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <=hi; k++) {
            if      (i > mid)               a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        isSorted(a, 0, a.length-1);
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(new File("/home/liupp/IdeaProjects/javaCode/src/", "words.txt"));

        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        String s = scanner.useDelimiter("\\n").next();
        String[] ss = s.split(" ");
        System.out.println(s);

        sort(ss);
        show(ss);
    }
}
