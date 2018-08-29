package javaCode.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || n < k)
            return new int[0];
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>(); //双端队列
        for (int i = 0, j = 0; i < n; i++) {

            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.add(i);
            if (i >= k - 1)
                result[j++] = nums[dq.peek()];
        }
        return result;
    }


    //蠢慢
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        int[] result = new int[n - k + 1];
//        if (n == 0 || n < k)
//            return new int[0];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = findMax(nums, i, i+k);
//        }
//        return result;
//    }
//
//    public int findMax(int[] nums, int lo, int hi) {
//        int max = nums[lo];
//        for (int i = lo + 1; i < hi; i++) {
//            max = max >= nums[i] ? max : nums[i];
//        }
//        return max;
//    }
}
