package javaCode.solutions;

import java.util.*;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = find(root);
        return depth;
    }

    public int find(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(find(root.left), find(root.right));
    }

    public int TreeDepth2(TreeNode root) {
        if (root == null) return 0;
        int depth = 0, count = 0, nextCount = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            count ++;
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);

            if (count == nextCount) {
                nextCount = queue.size();
                count = 0;
                depth++;
            }

        }
        return depth;
    }

    public int TreeDepth3(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();

                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }

        }
        return depth;
    }

    public static void main(String[] args) {
        TreeDepth td = new TreeDepth();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(0);
        System.out.println(td.TreeDepth(root));
        System.out.println(td.TreeDepth2(root));
        System.out.println(td.TreeDepth3(root));
    }
}
