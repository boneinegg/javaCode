package javaCode.solutions.chapter_1;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;

public class Sol21 {
//    public static void main(String[] args) {
//        System.out.print("Please input count:");
//        int n = StdIn.readInt();
//        String[] nameArray = new String[n];
//        int[] integerArray1 = new int[n];
//        int[] integerArray2 = new int[n];
//        for (int i = 0; i < n; i++) {
//            nameArray[i] = StdIn.readString();
//            integerArray1[i] = StdIn.readInt();
//            integerArray2[i] = StdIn.readInt();
//        }
//        System.out.println("庚----房----房----房------庖");
//        for (int i = 0; i < n; i++) {
//            System.out.printf("|%4s|%4d|%4d|%6.3f|\n", nameArray[i], integerArray1[i], integerArray2[i],
//                    (float) integerArray1[i] / integerArray2[i]);
//            if (i != n - 1) {
//                System.out.println("念----拈----拈----拈------怕");
//            }
//        }
//        System.out.println("弩----拂----拂----拂------彼");
//    }
    public static void main(String[] args) {
        int n = StdIn.readInt();
        String[] name = new String[n];
        int[] x = new int[n];
        int[] y = new int[n];
        int i = 0;
        while (i < n) {
            name[i] = StdIn.readString();
            x[i] = StdIn.readInt();
            y[i] = StdIn.readInt();
            i++;
        }
        System.out.println("姓名    " + "x    " + "y    " + "分数    ");
        for (int j = 0; j < n; j++) {
            System.out.printf("%4s %4d %4d %6.3f\n", name[j], x[j], y[j], (float)(x[j] / y[j]));
//            System.out.println(name[j] + x[j] + y[j]);
        }
    }
}
