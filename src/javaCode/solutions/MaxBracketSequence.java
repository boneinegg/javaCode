package javaCode.solutions;

/**
 * 一个合法的括号匹配序列被定义为:
 * 1. 空串""是合法的括号序列
 * 2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
 * 3. 如果"X"是一个合法的序列,那么"(X)"也是一个合法的括号序列
 * 4. 每个合法的括号序列都可以由上面的规则生成
 * 例如"", "()", "()()()", "(()())", "(((()))"都是合法的。
 * 从一个字符串S中移除零个或者多个字符得到的序列称为S的子序列。
 * 例如"abcde"的子序列有"abe","","abcde"等。
 * 定义LCS(S,T)为字符串S和字符串T最长公共子序列的长度,即一个最长的序列W既是S的子序列也是T的子序列的长度。
 * 小易给出一个合法的括号匹配序列s,小易希望你能找出具有以下特征的括号序列t:
 * 1、t跟s不同,但是长度相同
 * 2、t也是一个合法的括号匹配序列
 * 3、LCS(s, t)是满足上述两个条件的t中最大的
 * 因为这样的t可能存在多个,小易需要你计算出满足条件的t有多少个。
 *
 * 如样例所示: s = "(())()",跟字符串s长度相同的合法括号匹配序列有:
 * "()(())", "((()))", "()()()", "(()())",其中LCS( "(())()", "()(())" )为4,其他三个都为5,所以输出3.
 * 输入描述:
 *
 * 输入包括字符串s(4 ≤ |s| ≤ 50,|s|表示字符串长度),保证s是一个合法的括号匹配序列。
 *
 * 输出描述:
 *
 * 输出一个正整数,满足条件的t的个数。
 *
 *
 * 输入例子1:
 *
 * (())()
 *
 *
 * 输出例子1:
 *
 * 3
 */
import java.util.*;

public class MaxBracketSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String t = s.substring(0, i) + s.substring(i+1);
//            System.out.println(t);
            for (int j = 0; j < n - 1; j++) {
                String temp = t.substring(0, j) + s.charAt(i) + t.substring(j);
//                System.out.println(temp);
                int count = 0;
                for (int k = 0; k < n; k++) {
                    count += (temp.charAt(k) == '(' ? 1 : -1);
                    if (count < 0)
                        break;
                }
                if (count >= 0)
                    set.add(temp);
            }

        }
        System.out.println(set.size()-1);
        in.close();
    }
}