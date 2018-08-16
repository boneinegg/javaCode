package javaCode;

import java.util.ArrayList;
import java.util.Scanner;

import static javaCode.Main2.find;

public class Main2 {
    public static int find(int key, int[] a) {
        int sum = 0, i;
        for (i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum >= key)
                break;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] sum = new int[n+1];
        sum[0] = 0;
        ArrayList array = new ArrayList();
        for (int i = 0; i < n; i++) {
            array.add(scanner.nextInt());
        }
        int m = scanner.nextInt(), q;
        for (int i = 0; i < m; i++) {
            q = scanner.nextInt();
            for (int j = 1; j < sum.length; j++) {
                System.out.println(sum[j]);
                if (q <= sum[j]) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}
