package org.example.infrastructure.algorithm.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @description: 非递归遍历
 * @Author BAISHUN
 * @Date 2024/9/9 16:40
 */
public class NoRecursionTraversal {

    public static void main(String[] args) {
        /*
         *      1
         *     / \
         *    2   3
         *
         * */
        TreeNode tree = TreeNode.createBinaryTreeFromLevelOrder("[1,2,3]");
        preOrder(tree);
        System.out.println();
        inOrder(tree);
        System.out.println();
        postOrder(tree);
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) {
                continue;
            }
            System.out.print(cur.val + " ");
            stack.push(cur.right);
            stack.push(cur.left);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
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

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(0, node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        for (TreeNode n : list) {
            System.out.print(n.val + " ");
        }
    }


}
