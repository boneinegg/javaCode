package javaCode.solutions.chapter_1;

import edu.princeton.cs.algs4.StdIn;

public class Sol05 {
    public static void main(String[] args) {
        double x = StdIn.readDouble();
        double y = StdIn.readDouble();

        if (0.0 < x && x < 1.0 && 0 < y && y < 1)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
