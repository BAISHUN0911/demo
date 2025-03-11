package org.example.infrastructure.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 层序遍历二叉树
 *
 * @Author BAISHUN
 * @Date: 2024/6/26 17:09
 */
public class LevelTraversal {
    public static void main(String[] args) {
        String s1 = "[1,2,2,3,null,null,3,4,null,null,4]";
        TreeNode tree = TreeNode.createBinaryTreeFromLevelOrder(s1);
        List<List<Integer>> lists = levelOrder(tree);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    /**
     * 二叉树的层序遍历 使用队列
     *
     * @param root 树根
     * @return 集合 每一层的节点放在一个List集合中，最终放在一个大的List集合中
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return null;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();   // 这里必须要出队
                level.add(cur.val);
                // 将每个节点的左右节点入队
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            lists.add(level);
        }

        return lists;
    }
}
