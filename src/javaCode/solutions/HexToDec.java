package javaCode.solutions;

import java.util.Scanner;

public class HexToDec {
    public static int hexTodec(char[] cs) {
        int e = 0;
        int result = 0;
        for (int i = cs.length-1; i >= 2; i--) {
            result += charToInt(cs[i]) * Math.pow(16, e);
            e++;
        }
        return result;
    }

    public static int charToInt(char c) {
        if (c == 'A' || c == 'a')
            return 10;
        else if (c == 'B' || c == 'b')
            return 11;
        else if (c == 'C' || c == 'c')
            return 12;
        else if (c == 'D' || c == 'd')
            return 13;
        else if (c == 'E' || c == 'e')
            return 14;
        else if (c == 'F' || c == 'f')
            return 15;
        else
            return c - '0';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        String s;
        while (in.hasNext()) {
            s = in.next();
//            if (s.length() < 3 || !s.substring(0, 2).equals("0x") || !s.substring(0, 2).equals("0X"))
//                continue;
            char[] cs = s.toCharArray();
            System.out.println(hexTodec(cs));
        }
    }
}
