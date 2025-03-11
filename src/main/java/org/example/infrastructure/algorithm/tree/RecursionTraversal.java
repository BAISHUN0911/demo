package org.example.infrastructure.algorithm.tree;

/**
 * @description: 二叉树前中后序遍历，递归
 * @Author BAISHUN
 * @Date 2024/9/9 16:12
 */
public class RecursionTraversal {

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
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

}
