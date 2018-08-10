package javaCode;

import java.util.*;
import java.time.LocalDate;
public class Main {

    public static long f(long n) {
        if (n == 0 || n == 1)
            return 1;
        return f(n - 1) + f(n - 2);
    }

    public static void count(long n) {
        long tmp = n - ((n >> 1) & 033333333333) - ((n >> 2) & 011111111111);
        System.out.println(((tmp + (tmp >> 3)) & 030707070707) % 63);
    }

    public static void main(String[] args) {
	// write your code here
        count(f(7));
        count(f(9));
    }
}
