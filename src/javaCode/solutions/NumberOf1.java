package javaCode.solutions;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * 整数中1出现的次数(从1到n整数中1出现的次数)
 */
public class NumberOf1 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1)      return 0;
        if (n < 10)      return 1;
        int count = 1;
        for (int i = 10; i <= n; i++) {
            count += find(i);
        }
        return count;
    }

    public int find(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 10 == 1)
                count++;
            n /= 10;
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i,b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1 test = new NumberOf1();
        Stopwatch timer1 = new Stopwatch();
        int result = test.NumberOf1Between1AndN_Solution(111111111);
        double t1 = timer1.elapsedTime();

        Stopwatch timer2 = new Stopwatch();
        int result2 = test.NumberOf1Between1AndN_Solution2(111111111);
        double t2 = timer2.elapsedTime();

        System.out.println(result + ": " + t1);
        System.out.println(result2 + ": " + t2);
    }
}
