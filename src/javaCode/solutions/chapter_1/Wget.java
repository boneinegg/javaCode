package javaCode.solutions.chapter_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdIn;

public class Wget {

    public static void main(String[] args) {
        String url = StdIn.readString();
        In in = new In(url);
        String data = in.readAll();

        String filename = url.substring(url.lastIndexOf('/') + 1);
        Out out = new Out(filename);
        out.println(data);
        out.close();
    }
}
