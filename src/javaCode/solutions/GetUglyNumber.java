package javaCode.solutions;

/**
 * 题目描述：
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，
 * 但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小
 * 到大的顺序的第N个丑数。
 */
public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) return 0;

        int[] result = new int[index];
        result[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(Math.min(2*result[p2], 3*result[p3]), 5*result[p5]);
            while (result[p2] * 2 <= result[i])
                p2++;
            while (result[p3] * 3 <= result[i])
                p3++;
            while (result[p5] * 5 <= result[i])
                p5++;
//            System.out.println(result[i]);
        }

        return result[index-1];
    }

    public static void main(String[] args) {
        GetUglyNumber t = new GetUglyNumber();
        System.out.println(t.GetUglyNumber_Solution(10));
    }
}
