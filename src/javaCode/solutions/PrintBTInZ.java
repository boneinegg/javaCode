package javaCode.solutions;

import javaCode.datastructure.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintBTInZ {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> line = new ArrayList<>();
        queue.add(pRoot);
        int count = 0, nextCount = 1, depth = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            line.add(temp.val);
            count++;

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);

            if (count == nextCount) {
                if (++depth % 2 == 1)
                    result.add(line);
                else {
                    ArrayList<Integer> rev = new ArrayList<>();
                    for (int i = line.size()-1; i >= 0; i--)
//                    for (int i = 0; i < line.size(); i++)
                        rev.add(line.get(i));
                    result.add(rev);
                }
                line = new ArrayList<>();
                nextCount = queue.size();
                count = 0;
            }
        }
//        for (ArrayList<Integer> integers : result) {
//            for (Integer i : integers)
//                System.out.print(i + " ");
//            System.out.println();
//        }
        return result;
    }

    public static void main(String[] args) {
        PrintBTInZ is = new PrintBTInZ();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(7);
        System.out.println(is.Print(root));
//        for (Integer i : is.vals)
//            System.out.println(i);
    }

}
