package javaCode.solutions;

import java.util.*;

/**
 *
 输入描述:

 输入包含多组测试数据。

 对于每组测试数据：

 N - 本组测试数据有n个数

 a1,a2...an - 需要计算的数据

 保证:

 1<=N<=100000,0<=ai<=INT_MAX.

 输出描述:


 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。


 输入例子1:

 6
 45 12 45 32 5 6


 输出例子1:

 1 2
 *
 */
public class DiffOfCouple {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        while (in.hasNextInt()) {
            n = in.nextInt();
            int[] vals = new int[n];
            for (int i = 0; i < n; i++) {
                vals[i] = in.nextInt();
            }
            //排序
            Arrays.sort(vals);

            //元素全一样或者数量少于2
            int minN = 0, maxN = 0;
            if (vals[0] == vals[n-1]) {
                minN = n * (n - 1) / 2;
                maxN =minN;
                System.out.println(minN + " " + maxN);
                continue;
            }

            //存放每种元素对应个数
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (map.containsKey(vals[i])) {
                    map.put(vals[i], map.get(vals[i]) + 1);
                } else
                    map.put(vals[i], 1);
                //最大差为首位元素个数乘积
                if (i == n - 1) {
                    maxN = map.get(vals[0]) * map.get(vals[i]);
                }
            }

            //元素各不相同时求相邻元素差值，取最小差值及计算对数
            if (map.size() == n) {
                int min = Math.abs(vals[1] - vals[0]);
                for (int i = 2; i < n; i++) {
                    int temp = Math.abs(vals[i] - vals[i-1]);
                    if (temp < min) {
                        min = temp;
                        minN = 1;
                    }
                    else if (temp == min)
                        minN++;
                }
            }
            //存在重复元素则最小差值为0，根据重复元素个数代入公式n*(n-1)/2求对数
            else {
                for (Integer k : map.keySet()) {
                    int temp = map.get(k);
                    if (temp > 1) {
                        minN += (temp * (temp - 1) / 2);
                    }
                }
            }
            System.out.println(minN + " " + maxN);
        }
    }
}