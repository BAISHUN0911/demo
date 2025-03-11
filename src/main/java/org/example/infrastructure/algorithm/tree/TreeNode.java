package org.example.infrastructure.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/12 16:54
 */
public class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 根据二叉树层序遍历结果构建二叉树
     *
     * @param s 层序遍历字符串
     * @return 二叉树根节点
     */
    public static TreeNode createBinaryTreeFromLevelOrder(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        String[] arr = s.substring(1, s.length() - 1).split(",");
        // 树根节点不能为null
        if (arr[0] == null) {
            return null;
        }
        Integer[] array = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("null")) {
                array[i] = Integer.parseInt(arr[i]);
            } else {
                array[i] = null;
            }
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.offer(root);

        for (int i = 1; i < array.length; i++) {
            TreeNode current = queue.poll();
            if (array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.offer(current.left);
            }
            if (++i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.offer(current.right);
            }
        }

        return root;
    }
}
