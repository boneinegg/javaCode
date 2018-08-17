package javaCode;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars",
                "jupiter", "Saturn", "Uranus", "Neptune"};
//        System.out.println(Arrays.toString(planets));
//        System.out.println("Sorted in dictionary order: ");
//        Arrays.sort(planets);
//        System.out.println(Arrays.toString(planets));
//        System.out.println("Sorted by length: ");
//        Arrays.sort(planets, (first, second) -> first.length() - second.length());
//        System.out.println(Arrays.toString(planets));
//
//        Timer t = new Timer(1000, event ->
//                System.out.println("The time is " + new Date()));
//        Timer t2 = new Timer(1000, System.out::println);
//        t.start();
//
//        JOptionPane.showMessageDialog(null, "Quit program?");
//        System.exit(0);

        repeat(10, i -> System.out.println("Countdonw: " + (9 - i)));
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++)
            action.accept(i);
    }
}

interface IntConsumer {
    void accept(int value);
}

