package javaCode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 *     void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 *     double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 * 进阶:
 *
 *     如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 *     如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class MedianFinder {
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    private PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    public void Insert(Integer num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    public Double GetMedian() {
        if (max.size() == min.size())
            return (max.peek() + min.peek()) / 2.0;
        return max.peek() * 1.0;
    }

//    蠢慢
//    private ArrayList<Integer> a = new ArrayList<>();
//
//    public void Insert(Integer num) {
//        a.add(num);
//    }
//
//    public Double GetMedian() {
//        Collections.sort(a);
//        int i = a.size();
//        if (i % 2 == 0)
//            return (a.get(i / 2) + a.get(i / 2 -1)) / 2.0;
//        else
//            return a.get(i / 2) * 1.0;
//    }

}
