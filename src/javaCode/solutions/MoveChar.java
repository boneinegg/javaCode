package javaCode.solutions;


import java.util.Scanner;

public class MoveChar {
    public static String move(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        if (n <= 1)
            return s;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                if (!isUp(chars[j]) && isUp(chars[j-1])) {
                    char temp = chars[j];
                    chars[j] = chars[j-1];
                    chars[j-1] = temp;
                }
            }
        }
        return String.valueOf(chars);
    }

    public static boolean isUp(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(move(s));
        }
    }
}
