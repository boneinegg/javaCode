package javaCode.algs.sort;

import java.util.Scanner;

//单词全排列
public class Anagram {
    static int size;
    static int count;
    static char[] chars = new char[100];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        chars = s.toCharArray();
        size = s.length();
        count = 0;
        doAnagram(size);
    }

    public static void doAnagram(int n) {
        if (n == 1) return;
        for (int j = 0; j < n; j++) {
            doAnagram(n - 1);
            if (n == 2) {
                display();
            }
            rotate(n);
        }
    }

    public static void rotate(int n) {
        int j;
        int pos = size - n;
        char tmp = chars[pos];
        for (j = pos + 1; j < size; j++) {
            chars[j-1] = chars[j];
        }
        chars[j-1] = tmp;
    }

    public static void display() {
        if (count < 99)
            System.out.print(" ");
        if (count < 9)
            System.out.print(" ");
        System.out.print(++count + " ");
        for (int i = 0; i < size; i++)
            System.out.print(chars[i]);
        System.out.print("    ");
        System.out.flush();
        if (count % 6 == 0)
            System.out.println();

    }
}
