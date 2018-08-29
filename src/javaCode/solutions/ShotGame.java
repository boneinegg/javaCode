package javaCode.solutions;

import java.util.Scanner;

/**
 *  小易正在玩一款新出的射击游戏,这个射击游戏在一个二维平面进行,小易在坐标原点(0,0),平面上有n只怪物,
 *  每个怪物有所在的坐标(x[i], y[i])。小易进行一次射击会把x轴和y轴上(包含坐标原点)的怪物一次性消灭。
 * 小易是这个游戏的VIP玩家,他拥有两项特权操作:
 * 1、让平面内的所有怪物同时向任意同一方向移动任意同一距离
 * 2、让平面内的所有怪物同时对于小易(0,0)旋转任意同一角度
 * 小易要进行一次射击。小易在进行射击前,可以使用这两项特权操作任意次。
 * 小易想知道在他射击的时候最多可以同时消灭多少只怪物,请你帮帮小易。
 *
 * 输入描述:
 *
 * 输入包括三行。
 * 第一行中有一个正整数n(1 ≤ n ≤ 50),表示平面内的怪物数量。
 * 第二行包括n个整数x[i](-1,000,000 ≤ x[i] ≤ 1,000,000),表示每只怪物所在坐标的横坐标,以空格分割。
 * 第二行包括n个整数y[i](-1,000,000 ≤ y[i] ≤ 1,000,000),表示每只怪物所在坐标的纵坐标,以空格分割。
 *
 * 输出描述:
 *
 * 输出一个整数表示小易最多能消灭多少只怪物。
 *
 * 输入例子1:
 *
 5
 0 -1 1 1 -1
 0 -1 -1 1 1
 *
 * 输出例子1:
 *
 * 5
 */
public class ShotGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = in.nextInt();
        }
        in.close();

        int max = 0;
        if (n < 4) {
            max = n;
        }
        int dx1, dy1;
        int dx2, dy2;
        int dx3, dy3;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                dx1 = x[i] - x[j];
                dy1 = y[i] - y[j];
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j)
                        continue;
                    int count = 3;
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k)
                            continue;
                        dx2 = x[l] - x[k];
                        dy2 = y[l] - y[k];
                        dx3 = x[l] - x[i];
                        dy3 = y[l] - y[i];
                        if (dx3 * dy1 == dy3 * dx1 || dx1 * dx2 + dy1 * dy2 == 0)
                            count++;
                    }
                    if (count > max)
                        max = count;
                }
            }
        }
        System.out.println(max);
    }
}
