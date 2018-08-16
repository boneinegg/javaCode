package javaCode.solutions;


//反转句子中的单词
public class ReverseWords {
    public static String reverseWords1(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp;
        for (int i = 0; i < ss.length; i++) {
            tmp = new StringBuilder(ss[i]).reverse();
            sb.append(tmp + " ");
        }
        return sb.toString();
    }

    public static String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                int j = i;
                while (j + 1 < chars.length && chars[j + 1] != ' ') {
                    j++;
                }
                reverse(chars, i, j);
                i = j;
            }
        }
        return new String(chars);
    }

    public static String  reverseWords3(String s) {
        java.util.Stack stack = new java.util.Stack();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                stack.push(chars[i]);
            }
            if (chars[i] == ' ' || i == chars.length - 1) {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void reverse(char[] chars, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }


    public static String reverseWords4(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return reverseWords4(b) + reverseWords4(a);
    }

    public static void main(String[] args) {
        String s = "To be or not to be";
        String s1 = reverseWords1(s);
        String s2 = reverseWords2(s);
        String s3 = reverseWords3(s);

        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++)
            sb.append(reverseWords4(strings[i]) + " ");
        System.out.println(sb.toString());

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

}
