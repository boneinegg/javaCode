package javaCode.algs.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//单词全排列
public class Anagram {
    static int size;
    static int count;
    static char[] chars = new char[100];

    public static void doAnagram(int n) {
        if (n == 1) return;
        for (int j = 0; j < n; j++) {
            doAnagram(n - 1);
            if (n == 2) {
                display();
            }
            rotate(n);
        }
    }

    public static void rotate(int n) {
        int j;
        int pos = size - n;
        char tmp = chars[pos];
        for (j = pos + 1; j < size; j++) {
            chars[j-1] = chars[j];
        }
        chars[j-1] = tmp;
    }

    public static void display() {
        if (count < 99)
            System.out.print(" ");
        if (count < 9)
            System.out.print(" ");
        System.out.print(++count + " ");
        for (int i = 0; i < size; i++)
            System.out.print(chars[i]);
        System.out.print("    ");
        System.out.flush();
        if (count % 6 == 0)
            System.out.println();

    }


    /**
     * 
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null)    return result;
        char[] cs = str.toCharArray();
        int n = cs.length;
        Permutation(result, 0, n-1, cs);
        Collections.sort(result);
        return result;
    }
    public void Permutation(ArrayList<String> result, int lo, int hi, char[] cs) {
        if (lo == hi) {
            if (result.contains(String.valueOf(cs))) return;
            result.add(String.valueOf(cs));
        }
        else {
            for (int i = lo; i <= hi; i++) {
                swap(cs, i, lo);
                Permutation(result, lo + 1, hi, cs);
                swap(cs, i, lo);
            }
        }
    }
    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
//        chars = s.toCharArray();
//        size = s.length();
//        count = 0;
//        doAnagram(size);

       Anagram anagram = new Anagram();
       ArrayList<String> a = anagram.Permutation(s);
       for (String str : a)
           System.out.println(str);
    }

}
