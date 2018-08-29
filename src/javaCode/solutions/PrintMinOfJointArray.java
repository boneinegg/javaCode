package javaCode.solutions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinOfJointArray {
    private ArrayList<String> result = new ArrayList<>();
    private String[] strings;

    public String PrintMinNumber(int [] numbers) {
//        ArrayList<String> result = new ArrayList<>();
        int n = numbers.length;
        if (n <= 0)     return "";

        strings = new String[n];
        for (int i = 0; i < numbers.length; i++)
            strings[i] = String.valueOf(numbers[i]);

//        for (String s : strings)
//            System.out.println(s);
//            a.add(((Integer)numbers[i]).toString());

        find(0);
        Collections.sort(result);
        return result.get(0);
    }

    public void find(int index) {
        if (index == strings.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strings.length; i++)
                sb.append(strings[i]);
            if (!result.contains(sb.toString()))
                result.add(sb.toString());
        }
        else {
            for (int i = index; i < strings.length; i++) {
                swap(i, index);
                find(index + 1);
                swap(i, index);
            }
        }
    }
    public void swap(int i, int j) {
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    public static void main(String[] args) {
        PrintMinOfJointArray t = new PrintMinOfJointArray();
        int[] numbers = {3, 32, 321, 1};
        System.out.println(t.PrintMinNumber(numbers));
    }

}
