package javaCode.solutions;

import java.util.Scanner;

/**
 * 构造回文
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数。
 *
 * 输入描述:
 * 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 *
 * 输出描述:
 * 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
 *
 * 输入例子1:
 *
 * abcda
 * google
 *
 * 输出例子1:
 *
 * 2
 * 2
 */
public class BuildPalindrome {

    public static int maxLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        String r = sb.reverse().toString();
        char[] c1 = s.toCharArray();
        char[] c2 = r.toCharArray();

        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j= 1; j <= n; j++) {
                if (c1[i-1] == c2[j-1]) {
//                    dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]+1);
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        while (in.hasNextLine()) {
            s = in.nextLine();
            System.out.println(s.length() - maxLength(s));
        }
    }
}
