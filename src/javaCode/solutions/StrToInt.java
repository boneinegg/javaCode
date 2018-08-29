package javaCode.solutions;

/**
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 *
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例1
 * 输入
 *
 * +2147483647
 *     1a33
 *
 * 输出
 *
 * 2147483647
 *     0
 */
public class StrToInt {
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;

        char f = str.charAt(0);
        int result = 0;
        int s = 1;
        if (str.charAt(0) == '-')
            s = -1;
        for (int i = (f == '-' || f == '+') ? 1 : 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if (temp <= '9' && temp >= '0') {
                    result = (result << 1) + (result << 3) + (temp & 0xf);
                } else
                    return 0;
        }
        return result * s;
//        char f = str.charAt(0);
//        int result = 0;
//        if (f <= '9' && f >= '0') {
//            result += f - '0';
//            result *= 10;
//            for (int i = 1; i < str.length(); i++) {
//                char temp = str.charAt(i);
//                if (temp <= '9' && temp >= '0') {
//                    result += temp - '0';
//                    if (i != str.length()-1)
//                        result *= 10;
//                } else
//                    return 0;
//            }
//            return result;
//        }
//        else if (f == '-') {
//            for (int i = 1; i < str.length(); i++) {
//                char temp = str.charAt(i);
//                if (temp <= '9' && temp >= '0') {
//                    result += temp - '0';
//                    if (i != str.length()-1)
//                        result *= 10;
//                } else
//                    return 0;
//            }
//            return result / -1;
//        }
//        else if (f == '+') {
//            for (int i = 1; i < str.length(); i++) {
//                char temp = str.charAt(i);
//                if (temp <= '9' && temp >= '0') {
//                    result += temp - '0';
//                    if (i != str.length()-1)
//                        result *= 10;
//                } else
//                    return 0;
//            }
//            return result;
//        }
//        else
//            return 0;
    }

    public static void main(String[] args) {
        String s1 = "+214783";
        String s2 = "-2147483647";
        System.out.println(StrToInt(s1));
        System.out.println(StrToInt(s2));

//        System.out.println();
//        System.out.println(('9' -'0'));
//        System.out.println((int)'9');
//        System.out.println((int)'-');
//        System.out.println((int)'+');
    }
}
