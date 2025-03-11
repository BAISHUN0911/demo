package org.example.infrastructure.algorithm.tree;

/**
 * 代码描述
 *
 * @Author BAISHUN
 * @Date: 2024/6/12 16:54
 */
public class CalculateDepth {
    public static void main(String[] args) {
        String s1 = "[1,2,2,3]";
        TreeNode tree = TreeNode.createBinaryTreeFromLevelOrder(s1);
        System.out.println(calculateDepth(tree));
    }

    /**
     * 递归计算二叉树最大深度
     *
     * @param root 二叉树根节点
     * @return 长度
     */
    public static int calculateDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(calculateDepth(root.left), calculateDepth(root.right)) + 1;
    }


}
