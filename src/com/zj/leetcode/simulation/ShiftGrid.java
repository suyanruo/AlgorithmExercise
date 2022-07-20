package com.zj.leetcode.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/7/20 16:24
 * @description: 二维网格迁移
 * 给你一个 m 行 n列的二维网格grid和一个整数k。你需要将grid迁移k次。
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j]的元素将会移动到grid[i][j + 1]。
 * 位于grid[i][n- 1] 的元素将会移动到grid[i + 1][0]。
 * 位于 grid[m- 1][n - 1]的元素将会移动到grid[0][0]。
 * 请你返回k 次迁移操作后最终得到的 二维网格。
 *
 * 链接：https://leetcode.cn/problems/shift-2d-grid
 * ref: https://leetcode.cn/problems/shift-2d-grid/solution/by-ac_oier-1blt/
 */
public class ShiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int jump = k;
        if (k > m * n) {
            jump = k % (m * n);
        }
        int start = (m * n - jump) % (m * n);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m * n; i++ ) {
            if (i % n == 0) {
                if (i != 0) result.add(list);
                list = new ArrayList<>();
            }
            list.add(grid[start / n][start % n]);
            start = (start + 1) % (m * n);
        }
        result.add(list);
        return result;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{{1}};
        new ShiftGrid().shiftGrid(grid, 100);
    }
}
