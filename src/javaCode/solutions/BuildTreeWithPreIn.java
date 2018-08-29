package javaCode.solutions;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTreeWithPreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        return buildTree(0, preorder.length-1, preorder, 0, inorder.length-1, inorder);
    }

    public TreeNode buildTree(int plo, int phi, int[] pre, int ilo, int ihi, int[] in) {
        if (plo > phi || ilo > ihi)
            return null;
        TreeNode root = new TreeNode(pre[plo]);

        for (int i = ilo; i <= ihi; i++) {
            if (in[i] == pre[plo]) {
                root.left = buildTree(plo+1, plo+i-ilo, pre, ilo, i-1, in);
                root.right = buildTree(plo+i-ilo+1, phi, pre, i+1, ihi, in);
                break;
            }
        }
        return root;
    }
}
