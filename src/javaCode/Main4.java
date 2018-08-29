package javaCode;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Date;
import java.util.Queue;
import java.util.Stack;

public class Main4 {
    public static void main(String[] args) {

        Stopwatch timer = new Stopwatch();
        Stack<String> stringStack = new Stack<>();
        stringStack.push("aaa");
        stringStack.push("bbb");
        stringStack.iterator();
        int sum = 0;
        for (int i = 0; i < 1000000000; i++)
            sum += i;
        double time = timer.elapsedTime();
        System.out.println(time);
    }
}
