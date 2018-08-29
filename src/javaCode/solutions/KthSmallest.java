package javaCode.solutions;

import java.util.ArrayList;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 */
public class KthSmallest {

    //中序遍历结果存数组
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        ArrayList<Integer> result = new ArrayList<>();
        build(root, result);

        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
        if (k > result.size())
            return -1;
        return result.get(k-1);
    }

    public void build(TreeNode x, ArrayList<Integer> a) {
        if (x == null)
            return;

        build(x.left, a);
        a.add(x.val);
        build(x.right, a);
    }

    //中序遍历加计数器
    private int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot != null) {
            TreeNode result = KthNode(pRoot.left, k);
            if (result != null)
                return result;
            if (++count == k) return pRoot;
            result = KthNode(pRoot.right, k);
            if (result != null)
                return result;
        }
        return null;
    }
}
