package javaCode.solutions;

import java.util.ArrayList;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 输出描述:
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstAppearingOnce {

    private int[] count = new int[256];
    private StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        count[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (int i = 0; i < sb.length(); i ++) {
            if (count[sb.charAt(i)] == 1)
                return sb.charAt(i);
        }
        return '#';
    }

    public static void main(String[] args) {
        FirstAppearingOnce f = new FirstAppearingOnce();
        f.Insert('g');
        f.Insert('o');
        f.Insert('o');
        f.Insert('g');
        f.Insert('l');
        f.Insert('e');
        System.out.println(f.FirstAppearingOnce());

    }


}
