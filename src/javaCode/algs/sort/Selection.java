package javaCode.algs.sort;

import edu.princeton.cs.algs4.StdIn;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Selection {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j)  < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
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

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] a = StdIn.readAllStrings();
//        Arrays.sort(a);
        sort(a);
        isSorted(a);
        show(a);
    }
}
