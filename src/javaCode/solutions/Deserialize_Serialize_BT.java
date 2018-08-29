package javaCode.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Deserialize_Serialize_BT {

    String Serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder result = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);

        int count = 0, nextCount = 1, depth = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
//            count++;
            if (temp != null) {
                result.append(temp.val + " ");

                queue.add(temp.left);
                queue.add(temp.right);
            }
            else
                result.append("# ");
        }
        System.out.println(result.length());
        return result.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == "")
            return null;

        String[] vals = str.split(" ");
        TreeNode result = new TreeNode(Integer.valueOf(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(result);
        TreeNode temp;
        for (int i = 1; i < vals.length; i++) {
            temp = queue.poll();
            if (!vals[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.valueOf(vals[i]));
                temp.left = left;
                queue.add(temp.left);
            }

            if (!vals[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.valueOf(vals[i]));
                temp.right = right;
                queue.add(temp.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Deserialize_Serialize_BT is = new Deserialize_Serialize_BT();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(7);


        String s = "1 2 3 4 # # 5 6 # 7 # # # # #";
        TreeNode t = is.Deserialize(s);
        s = is.Serialize(t);
        System.out.println(s);
//        for (Integer i : is.vals)
//            System.out.println(i);
    }
}
