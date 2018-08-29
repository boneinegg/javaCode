package javaCode.solutions;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你
 * 把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输
 * 出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0)
            return str;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp1 = new StringBuilder(str);
        temp1.delete(0, n);
        StringBuilder temp2 = new StringBuilder(str);
        temp2.delete(n, str.length());

        sb.append(temp1).append(temp2);
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        LeftRotateString ls = new LeftRotateString();
        String s = "abcABC";
        int n = 3;
        ls.LeftRotateString(s, n);

        //简单
//        StringBuilder result = new StringBuilder(s + s);
//        n = n % s.length();
//        System.out.println(result.substring(n, n+s.length()));
    }
}
