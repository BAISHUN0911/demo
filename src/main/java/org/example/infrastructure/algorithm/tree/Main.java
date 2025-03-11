package org.example.infrastructure.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树常见算法题
 * @Author BAISHUN
 * @Date 2024/9/5 23:41
 */
public class Main {
    public static void main(String[] args) {
        /*
        *         1
        *        / \
        *       2   3
        *     / \  / \
        *    4  5 6   7
        *   /\ /\ /\  /\
        *  null  null null
        *
        * */
        TreeNode tree = TreeNode.createBinaryTreeFromLevelOrder("[1,2,3,4,5,6,7]");

        preOrder(tree);
        System.out.println();
        preOrderByStack(tree);
        System.out.println();

        inOrder(tree);
        System.out.println();
        inOrderByStack(tree);
        System.out.println();

        postOrder(tree);
        System.out.println();
        postOrderByList(tree);

    }

    private static void postOrderByList(TreeNode root) {
        if (root == null) return;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(0, cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    private static void postOrder(TreeNode tree) {
        if (tree == null) return;
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.print(tree.val + "  ");
    }

    private static void inOrderByStack(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    private static void inOrder(TreeNode tree) {
        if (tree == null) return;
        inOrder(tree.left);
        System.out.print(tree.val + " ");
        inOrder(tree.right);
    }

    private static void preOrderByStack(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) continue;
            System.out.print(cur.val + "  ");
            stack.push(cur.right);
            stack.push(cur.left);
        }

    }

    private static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static List<List<Integer>> levelPrint(TreeNode tree) {
        return new ArrayList<>();
    }
}
