package javaCode.solutions;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTreeWithPostIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(0, postorder.length-1, postorder, 0, inorder.length-1, inorder);
    }

    public TreeNode buildTree(int pl, int ph, int[] post, int il, int ih, int[] in) {
        if (pl > ph || il > ih)
            return null;
        TreeNode node = new TreeNode(post[ph]);

        for (int i = ih; i <= il; i-- ) {
            if (in[i] == post[ph]) {
                node.left = buildTree(pl, ph-(ih-i)-1, post, il, i-1, in);
                node.right = buildTree(ph-(ih-i), ph - 1, post, i+1, ih, in);
                break;
            }
        }
        return node;
    }
}
