package javaCode.solutions;

import java.util.HashMap;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 */
public class MaxPoints {
    static class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
    }

    //三重循环穷举
    public int maxPoints2(Point[] points) {
        int n = points.length;
        if (n == 0)     return 0;
        if (n <= 2)     return n;

        int max = 2;
        for (int i = 0; i < n; i++) {
            int overlap = 0, count = 1;
            for(int j = i + 1; j < n; j++) {
                int x1 = points[i].x - points[j].x;
                int y1 = points[i].y - points[j].y;
                if (x1 == 0 && y1 == 0) {
                    overlap++;
                }
                else {
                    count++;
                    for (int k = j+1; k < n; k++) {
                        int x2 = points[j].x - points[k].x;
                        int y2 = points[j].y - points[k].y;
                        if ((double) x1 * y2 == (double) y1 * x2) {
                            count++;
                        }
                    }
                }
                max = Math.max(max, overlap+count);
                count = 1;
            }
        }
        return max;
    }

    //map存储每条可能直线的点数，取最大
    public int maxPoints(Point[] points) {
        if (points.length == 0)
            return 0;
        if (points.length <= 2)
            return 2;
        int result = 0, overlap = 0, count = 0;

        //x1,y1和x2,y2确定直线，利用最大公约数化减△x和△y作为key
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = gcd(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    }
                    else {
                        map.get(x).put(y, 1);
                    }
                }
                else {
                    HashMap<Integer, Integer> temp = new HashMap<>();
                    temp.put(y, 1);
                    map.put(x, temp);
                }
                count = Math.max(count, map.get(x).get(y));
            }
            result = Math.max(result, count+overlap+1);
            map.clear();
            overlap = 0;
            count = 0;
        }
        return result;
    }

    public int gcd(int x, int y) {
        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 65536);
        Point p3 = new Point(65536, 0);
        Point[] p = {p1, p2, p3};
        MaxPoints mp = new MaxPoints();
        System.out.println(mp.maxPoints(p));
        System.out.println(mp.maxPoints2(p));
        System.out.println(65536 * 65535);
    }
}
