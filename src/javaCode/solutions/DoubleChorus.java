package javaCode.solutions;

import java.util.Scanner;

/**
 * 小Q和牛博士合唱一首歌曲,这首歌曲由n个音调组成,每个音调由一个正整数表示。
 * 对于每个音调要么由小Q演唱要么由牛博士演唱,对于一系列音调演唱的难度等于所有相邻音调变化幅度之和, 例如一个音调序列是8, 8, 13, 12, 那么它的难度等于|8 - 8| + |13 - 8| + |12 - 13| = 6(其中||表示绝对值)。
 * 现在要对把这n个音调分配给小Q或牛博士,让他们演唱的难度之和最小,请你算算最小的难度和是多少。
 * 如样例所示: 小Q选择演唱{5, 6}难度为1, 牛博士选择演唱{1, 2, 1}难度为2,难度之和为3,这一个是最小难度和的方案了。
 * 输入描述:
 *
 * 输入包括两行,第一行一个正整数n(1 ≤ n ≤ 2000) 第二行n个整数v[i](1 ≤ v[i] ≤ 10^6), 表示每个音调。
 *
 * 输出描述:
 *
 * 输出一个整数,表示小Q和牛博士演唱最小的难度和是多少。
 *
 * 示例1
 * 输入
 *
 * 5
 * 1 5 6 2 1
 *
 * 输出
 *
 * 3
 */
public class DoubleChorus {
    private static int[] vals;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        vals = new int[n];
        for (int i = 0; i < n; i++)
            vals[i] = in.nextInt();

        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (j < i - 1) {
                    dp[i][j] = dp[i-1][j] + diff(i-1, i);
                }

                if (j == i - 1) {
                    int min = -1;
                    for (int k = 0; k < i - 1; k++) {
                        int temp = dp[j][k] + diff(k, i);
                        if (min == -1 || min > temp)
                            min = temp;
                    }
                    if (min == -1)
                        min = 0;
                    dp[i][j] = min;
                }
            }
        }

        int cost = -1;
        for (int i = 0; i < n; i++) {
            if (cost == -1 || cost > dp[n][i])
                cost = dp[n][i];
        }
        System.out.println(cost);
    }

    public static int diff(int i, int j) {
        if (i == 0)
            return 0;
        return Math.abs(vals[i-1] - vals[j-1]);
    }

    public static void get(String s) {

    }
    public static void get(int n) {

    }
}
