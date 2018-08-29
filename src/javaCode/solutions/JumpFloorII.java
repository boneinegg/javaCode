package javaCode.solutions;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {

    //f(n) = 2 * f(n-1) = 2^(n-1)
    public int JumpFloorII(int target) {
        int a = 1;
        return a << (target-1);
    }

    //f(n) = f(n-1) + f(n-2) + ... + f(1)
    public int JumpFloorII2(int target) {
        if (target == 0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int[] result = new int[target+1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= target; i++) {
            result[i] = 1;
            for (int j = 1; j < i; j++) {
                result[i] += result[j];
            }
        }
        return result[target];
    }

}
