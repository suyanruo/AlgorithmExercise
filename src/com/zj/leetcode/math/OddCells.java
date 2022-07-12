package com.zj.leetcode.math;

/**
 * @author: zhangjian
 * @date: 2022/7/12 18:45
 * @description: 奇数值单元格的数目
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 * 另有一个二维索引数组indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有indices指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 *
 * 链接：https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix
 * ref: https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/solution/by-ac_oier-p0za/
 */
public class OddCells {
    public int oddCells(int m, int n, int[][] ins) {
        boolean[] r = new boolean[m];
        boolean[] c = new boolean[n];
        int a = 0, b = 0;
        for (int[] in : ins) {
            a += (r[in[0]] = !r[in[0]]) ? 1 : -1;
            b += (c[in[1]] = !r[in[1]]) ? 1 : -1;
        }
        return a * (n - b) + b * (m - a);
    }
}
