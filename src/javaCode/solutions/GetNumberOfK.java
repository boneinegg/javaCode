package javaCode.solutions;

/**
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int GetNumberOfK(int[] array , int k) {
        if (array.length == 0)  return 0;
        int f = binarySearchFirst(array, k, 0, array.length-1);
        int l = binarySearchLast(array, k, 0, array.length-1);
        if (f != -1 && l != -1)
            return l - f + 1;
        return 0;
//        int count = 0;
//        if (f != -1)
//            for (int i = f; i < array.length; i++)
//                if (k == array[i])
//                    count++;
//        return count;
    }

    public int binarySearchFirst(int[] array, int k, int lo, int hi) {
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if     (k < array[mid]) hi = mid - 1;
            else if     (k > array[mid]) lo = mid + 1;
            else if (mid > 0 && k == array[mid - 1])
                hi = mid - 1;
            else     return mid;
        }
        return -1;
    }

    public int binarySearchLast(int[] array, int k, int lo, int hi) {
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if     (k < array[mid]) hi = mid - 1;
            else if     (k > array[mid]) lo = mid + 1;
            else if (mid < array.length-1 && k == array[mid + 1])
                lo = mid + 1;
            else     return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        GetNumberOfK f = new GetNumberOfK();

        int[] array = {2, 2, 2, 2, 2, 2};
        System.out.println(f.GetNumberOfK(array, 2));
    }
}
