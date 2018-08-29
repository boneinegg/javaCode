package javaCode.solutions;

import java.util.ArrayList;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快
 * 的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出描述:
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * S = (a1 + an) * n / 2
 * n = an - a1 + 1
 *
 * n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 && sum % n == 0；
 * n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，所以条件为：(sum % n) * 2 == n
 *
 * Math.sqrt(2S) > n
 */
public class FindContinousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int n = (int) Math.sqrt(sum*2); n >= 2; n--) {
            if (n % 2 == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> array = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n -1) / 2; j < n; j++, k++) {
                    array.add(k);
                }
                result.add(array);
            }
        }
//        System.out.println((int) Math.sqrt(sum*2));
//        for (ArrayList<Integer> a : result) {
//            for (Integer i : a) {
//                System.out.println(i);
//            }
//            System.out.println();
//        }
        return result;
    }

    public static void main(String[] args) {
        FindContinousSequence fcs = new FindContinousSequence();
        fcs.FindContinuousSequence(3);
    }
}
