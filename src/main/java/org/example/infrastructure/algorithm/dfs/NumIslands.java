package org.example.infrastructure.algorithm.dfs;

/**
 * 求岛屿数量  使用到了DFS思想、递归
 *
 * @Author BAISHUN
 * @Date: 2024/6/13 16:11
 */
public class NumIslands {
    public static void main(String[] args) {
        char[][] arr = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
//        char[][] arr = {{'1', '1', '1', '1'}};
//        char[][] arr = {
//                {'0','1','0'},
//                {'1','0','1'},
//                {'0','1','0'}
//        };
        int i = new NumIslands().numIslandsFromGpt(arr);
        System.out.println("总岛屿数为：" + i);
    }

    public int numIslandsFromGpt(char[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int rows = arr.length;
        int cols = arr[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == '1') {
                    count++;
                    // 递归标记通过该点可以到达的位置
                    dfsMarking(arr, i, j);
                }
            }
        }

        return count;
    }

    /**
     * dfs标记通过当前坐标可到达的地方，只是标记所以无返回值
     *
     * @param grid 岛屿数组
     * @param i 行坐标
     * @param j 列坐标
     */
    private void dfsMarking(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 递归终止条件 当前坐标不是1，或者超出数组界限
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] != '1') {
            return;
        }
        // 标记为已访问
        grid[i][j] = '0';

        // 递归尝试 上、下、左、右四个坐标是否可达
        dfsMarking(grid, i + 1, j);
        dfsMarking(grid, i - 1, j);
        dfsMarking(grid, i, j + 1);
        dfsMarking(grid, i, j - 1);
    }
}
