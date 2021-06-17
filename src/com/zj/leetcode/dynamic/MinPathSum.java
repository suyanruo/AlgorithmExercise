package com.zj.leetcode.dynamic;

/**
 * Created by ZhangJian on 2021/6/17.
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * link:https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[i][j] = grid[i][j];
                } else if (i == 0) {
                    f[i][j] = f[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    f[i][j] = f[i - 1][j] + grid[i][j];
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
