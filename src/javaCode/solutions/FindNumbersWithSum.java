package javaCode.solutions;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 *
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {

    //暴力不可取
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length < 2)
            return result;
        for (int i = 0; i < array.length; i++) {
            int j = binarySearch(array, sum - array[i]);
            if (j != -1 && j != i) {
                if (result.isEmpty()) {
                    result.add(Math.min(array[i], array[j]));
                    result.add(Math.max(array[i], array[j]));
                }
                int temp = result.get(0);
                if (!result.contains(array[i]) && array[i] * array[j] < temp * (sum - temp)) {
//                    result.add(array[i] <= array[j] ? array[i] : array[j]);
//                    result.add(array[i] <= array[j] ? array[j] : array[i]);
                    result.add(Math.min(array[i], array[j]));
                    result.add(Math.max(array[i], array[j]));
                }
            }
        }
        for (int i : result)
            System.out.println(i);
        return result;
    }

    public int binarySearch(int[] array, int k) {
        int lo = 0, hi = array.length - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (k < array[mid])         hi = mid - 1;
            else if (k > array[mid])    lo = mid + 1;
            else                        return mid;
        }
        return -1;
    }

    //两边夹逼
    public ArrayList<Integer> FindNumbersWithSum2(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length < 2)
            return result;
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum){
                result.add(array[i]);
                result.add(array[j]);
                break;
            }
            else if (array[i] + array[j] < sum) {
                i++;
            }
            else {
                j--;
            }
        }
        for (int k : result)
            System.out.println(k);
        return result;
    }

    public static void main(String[] args) {
        FindNumbersWithSum f = new FindNumbersWithSum();
        int[] array = {1, 2, 3, 4, 4, 5, 6, 7};
        int[] array2= {1,2,4,7,11,15};
        f.FindNumbersWithSum(array, 8);
        f.FindNumbersWithSum2(array2, 15);
    }
}
