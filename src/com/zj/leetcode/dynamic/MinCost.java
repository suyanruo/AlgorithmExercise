package com.zj.leetcode.dynamic;

/**
 * @author: zhangjian
 * @date: 2022/6/25 11:39
 * @description:
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个n x 3的正整数矩阵 costs 来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2]表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 请计算出粉刷完所有房子最少的花费成本。
 *
 * 链接：https://leetcode.cn/problems/JEj789
 * https://leetcode.cn/problems/JEj789/solution/by-ac_oier-6v2v/
 */
public class MinCost {
    public int minCost(int[][] costs) {
        int a = costs[0][0], b = costs[0][1], c = costs[0][2], d, e, f;
        for (int i = 1; i < costs.length; i++) {
            d = Math.min(b, c) + costs[i][0];
            e = Math.min(a, c) + costs[i][1];
            f = Math.min(a, b) + costs[i][2];
            a = d; b = e; c = f;
        }
        return Math.min(Math.min(a, b), c);
    }
}
