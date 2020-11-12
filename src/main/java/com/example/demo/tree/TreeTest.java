package com.example.demo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTest {

    public static void main(String[] args) {

    }

    /**
     * 前序遍历 （递归）
     *
     *      * 给定一个二叉树，返回它的 前序 遍历。
     *      * [1,null,2,3]
     *      *    1
     *      *     \
     *      *      2
     *      *     /
     *      *    3
     *      *
     *      *    输出: [1,2,3]
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (root.left != null) {
            list.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            list.addAll(preorderTraversal(root.right));
        }
        return list;
    }

    /**
     * 前序遍历 （栈）
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }

        return list;
    }
}
