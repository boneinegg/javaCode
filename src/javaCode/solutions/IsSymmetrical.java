package javaCode.solutions;

import java.util.ArrayList;

/**
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {

    private ArrayList<Integer> valsL = new ArrayList<>();
    private ArrayList<Integer> valsR = new ArrayList<>();

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode p, TreeNode q) {
        if (p == null)
            return q == null;
        if (q == null)
            return false;
       if (p.val != q.val)
           return false;

        return isSymmetrical(p.left, q.right) && isSymmetrical(p.right, q.left);
    }


    public void InorderTraversal(TreeNode x, ArrayList<Integer> vals) {
        if (x.left != null) {
//            vals.add(x.left.val);
            InorderTraversal(x.left, vals);
        }
        vals.add(x.val);
        if (x.right != null) {
//            vals.add(x.right.val);
            InorderTraversal(x.right, vals);
        }

    }

    public static void main(String[] args) {
        IsSymmetrical is = new IsSymmetrical();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        System.out.println(is.isSymmetrical(root));
//        for (Integer i : is.vals)
//            System.out.println(i);
    }

}
