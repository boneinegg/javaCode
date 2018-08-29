package javaCode.solutions.chapter_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Sattolo {

    // this class should not be instantiated
    private Sattolo() { }

    /**
     * Rearranges an array of objects to be a uniformly random cycle
     * (under the assumption that {@code Math.random()} generates independent
     * and uniformly distributed numbers between 0 and 1).
     * @param a the array to be rearranged
     * @see
     */
    public static void cycle(Object[] a) {
        int n = a.length;
        for (int i = n; i > 1; i--) {
            // choose index uniformly in [0, i-1)
            int r = (int) (Math.random() * (i-1));
            Object swap = a[r];
            a[r] = a[i-1];
            a[i-1] = swap;
        }
    }

    /**
     * Reads in a sequence of strings from standard input, shuffles
     * them, and prints out the results.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("input: ");
        // read in the data
//        String[] a = StdIn.readAllStrings();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = in.next();
        // shuffle the array
        Sattolo.cycle(a);

        // print results.
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }
}


