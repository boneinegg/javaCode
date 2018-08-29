package javaCode;

import java.util.Scanner;

public class Main3 {
    public static int f(int a, int b) {
        int ret = 1;
        while (a <= b) {
            ret *= a;
            a++;
        }
        return ret;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = f(m + 1, m + n) / f(1, n);
        String[] set = new String[sum];
        for (int i = 0; i < sum; i++) {

        }
        System.out.println(sum);
    }
}
