package javaCode.algs.sort;

import java.util.ArrayList;
import java.util.Scanner;

public class Selection {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[1000];
        ArrayList arrayList = new ArrayList();
        int i = 0, n;
        while(scanner.hasNextInt()) {
            n = scanner.nextInt();
            while (n > i) {
                arrayList.add(scanner.nextInt());
                i++;
            }
            System.out.println(arrayList);
            arrayList.clear();
            i = 0;
        }
    }
}
