package com.zj.leetcode.dynamic;

/**
 * Created by ZhangJian on 2021/6/17.
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    if (i > 0) {
                        f[i][j] += f[i - 1][j];
                    }
                    if (j > 0) {
                        f[i][j] += f[i][j - 1];
                    }
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
