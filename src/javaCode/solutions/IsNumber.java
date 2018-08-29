package javaCode.solutions;


/**
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 */
public class IsNumber {
    public static boolean isNumeric(char[] str) {
        if (str.length == 0)
            return false;

        //mark whether has decimal point or E/e
        boolean hasDecimal = false, hasE = false;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E' || str[i] == 'e') {
                //E/e must be follow by number
                if (i == str.length - 1)    return false;
                //only one E/e
                if (hasE)                   return false;
                hasE = true;
            }

            else if (str[i] == '-' || str[i] == '+') {
                // '+' or '-' must follow behind a 'E' or 'e', or at the beginning.
                if (i > 0 && str[i-1] != 'E' && str[i-1] != 'e')
                    return false;
//                if (hasSign)
//                    return false;
//                hasSign = true;
            }

            else if (str[i] == '.') {
                //There must be only one '.' and before E/e if both exist.
                if (hasDecimal || hasE)
                    return false;
                hasDecimal = true;
            }

            else if (str[i] > '9' || str[i] < '0')
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        char[] str = {'2', '3', 'a'};
        String s = "-1E-16";
        System.out.println(isNumeric(s.toCharArray()));
    }
}
