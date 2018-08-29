package javaCode.solutions;

/**
 *写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 二进制值相加： 5-101，7-111
 * 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
 * 第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
 * 第三步：重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
 * 继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
 */
public class AddInBinary {
    public static int Add(int num1, int num2) {
        int p = (num1 & num2) << 1;
        int q = num1 ^ num2;
        while (p != 0) {
            int temp = p;
            p = ((p & q) << 1) ;
            q = temp ^ q;
        }
        return p | q;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int n = A.length;
        int[] B = new int[n];
//        if (n == 0)
//            return B;
        int temp = 1;
        for (int i = 0; i < n; i++) {
            B[i] = temp;
            temp *= A[i];
        }
        temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= temp;
            temp *= A[i];
        }
        for (int i = 0; i < n; i++)
            System.out.println(B[i]);
        }

//        return B;
//        System.out.println(Add(2, -1));
}
