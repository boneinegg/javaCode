package javaCode.solutions.chapter_1;

import edu.princeton.cs.algs4.*;

public class Sol03 {
    public static void main(String[] args) {
        //read input
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();

        if (a == b && a == c)
            System.out.println("equal!");
        else
            System.out.println("not equal!");

        //args
        if (args.length < 3)
        {
            System.out.println("error");
            return;
        }
        if (args[0].equals(args[1]) && args[0].equals(args[2]))
            System.out.println("equal");
        else
            System.out.println("not equal");
    }
}
