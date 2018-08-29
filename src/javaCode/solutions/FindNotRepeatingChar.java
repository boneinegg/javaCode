package javaCode.solutions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FindNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null)    return -1;
//        char[] result = new char[256];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = 0;
//        }
//        char[] cs = str.toCharArray();
////        ArrayList<String> result = new ArrayList<>();
//        for (int i = 0; i < cs.length; i++) {
//            result[cs[i]]++;
//        }
//        for (int j = 0; j < result.length; j++) {
//            if (result[j] == 1)
//                return j;
//        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (hashMap.containsKey(temp)) {
                Integer val = hashMap.get(temp);
                hashMap.remove(temp);
                hashMap.put(temp, val+1);
            }
            else
                hashMap.put(temp, 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindNotRepeatingChar f = new FindNotRepeatingChar();
        System.out.println(f.FirstNotRepeatingChar("aAbbcC"));
    }
}
