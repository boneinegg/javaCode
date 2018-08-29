package javaCode.solutions;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 * 牛博士给小易出了一个难题:
 * 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 * 输入描述:
 *
 * 输入的第一行为数列的个数t(1 ≤ t ≤ 10),
 * 接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
 * 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)
 *
 * 输出描述:
 *
 * 对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。
 *
 * 输入例子1:
 *
 * 2
 * 3
 * 1 10 100
 * 4
 * 1 2 3 4
 *
 * 输出例子1:
 *
 * Yes
 * No
 * 思路：每个奇数左右两侧的数必须是4的倍数，因此只要求出奇数的个数和4的倍数的数的个数，后者大于前者即可输出“Yes”，否则输出“No”
 */
public class RearrangeSeries {
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, val, odd = 0, even4 = 0;

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            n = in.nextInt();

            for (int j = 0; j < n; j++) {
                val = in.nextInt();
                if (val % 4 == 0)
                    even4++;
                else if (val % 2 == 1)
                    odd++;
            }

            if (even4 >= odd)
                System.out.println("Yes");
            else
                System.out.println("No");
            odd = 0;
            even4 = 0;
        }
    }
}