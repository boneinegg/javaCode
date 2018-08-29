package javaCode.solutions;

import java.util.ArrayList;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    // 将num1[0],num2[0]设置为返回结果

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length < 2)
            return;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (!result.contains(array[i]))
                result.add(array[i]);
            else {
                int j = result.indexOf(array[i]);
                result.remove(j);
            }
        }
        num1[0] = result.get(0);
        num2[0] = result.get(1);
    }

    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        if (array.length < 2)
            return;
        int xor = 0, flag = 1;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }

        while ((xor & flag) == 0)
            flag <<= 1;

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & flag) == 0)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int[] array = {2, 2, 1, 1, 3, 4, 2, 2, 1, 1};
        FindNumAppearOnce fnao = new FindNumAppearOnce();
        fnao.FindNumsAppearOnce2(array, num1, num2);
        System.out.println(num1[0] + " " + num2[0]);
    }


}
