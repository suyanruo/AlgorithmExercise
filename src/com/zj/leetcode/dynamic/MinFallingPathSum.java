package com.zj.leetcode.dynamic;

/**
 * Created by ZhangJian on 2021/7/5.
 * 给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 示例 1：
 *
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：下面是两条和最小的下降路径，用加粗标注：
 * [[2,1,3],      [[2,1,3],
 *  [6,5,4],       [6,5,4],
 *  [7,8,9]]       [7,8,9]]
 *
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 * ref: https://leetcode-cn.com/problems/minimum-falling-path-sum/solution/dong-tai-gui-hua-lu-jing-wen-ti-zui-xiao-v2kp/
 */
public class MinFallingPathSum {
    public class Solution {
        private int MAX = Integer.MAX_VALUE;

        public int minFallingPathSum(int[][] matrix) {
            int ans = MAX;
            for (int i = 0; i < matrix.length; i++) {
                ans = Math.min(ans, find(matrix, i));
            }
            return ans;
        }

        private int find(int[][] matrix, int u) {
            int n = matrix.length;
            int[][] f = new int[n][n];
            for (int i = 0; i < n; i++) f[0][i] = (i == u) ? matrix[0][i] : MAX;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[i][j] = MAX;
                    if (f[i - 1][j] != MAX) f[i][j] = Math.min(f[i][j], f[i - 1][j] + matrix[i][j]);
                    if (j - 1 >= 0 && f[i - 1][j - 1] != MAX) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + matrix[i][j]);
                    if (j + 1 < n && f[i - 1][j + 1] != MAX) f[i][j] = Math.min(f[i][j], f[i - 1][j + 1] + matrix[i][j]);
                }
            }
            int ans = MAX;
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, f[n - 1][i]);
            }
            return ans;
        }
    }

    public class Solution2 {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            if (n == 1) return matrix[0][0];
            int ans = Integer.MAX_VALUE;
            int[][] f = new int[n][n];
            for (int i = 0; i < n; i++) {
                f[0][i] = matrix[0][i];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int ma = matrix[i][j];
                    if (j > 0 && j < n - 1) {
                        f[i][j] = Math.min(f[i - 1][j], Math.min(f[i - 1][j - 1], f[i - 1][j + 1])) + ma;
                    } else if (j == 0) {
                        f[i][j] = Math.min(f[i - 1][j], f[i - 1][j + 1]) + ma;
                    } else {
                        f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + ma;
                    }
                    if (i == n - 1) {
                        ans = Math.min(ans, f[i][j]);
                    }
                }
            }
            return ans;
        }
    }
}
