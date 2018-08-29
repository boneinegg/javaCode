package javaCode.solutions;


/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalancedBT {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return false;
        if (root.left != null) IsBalanced_Solution(root.left);
        if (root.right != null) IsBalanced_Solution(root.right);
        int d = find(root.left) - find(root.right);

        return d >= -1 && d <= 1 ;
    }

    public int find(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(find(root.left), find(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        IsBalancedBT ib = new IsBalancedBT();
        System.out.println(ib.IsBalanced_Solution(root));
    }
}
