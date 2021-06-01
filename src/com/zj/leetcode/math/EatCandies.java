package com.zj.leetcode.math;

/**
 * Created by ZhangJian on 2021/6/1.
 * 给你一个下标从 0 开始的正整数数组candiesCount，其中candiesCount[i]表示你拥有的第i类糖果的数目。同时给你一个二维数组queries，其中queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]。
 * 你按照如下规则进行一场游戏：
 * 你从第0天开始吃糖果。
 * 你在吃完 所有第 i - 1类糖果之前，不能吃任何一颗第 i类糖果。
 * 在吃完所有糖果之前，你必须每天 至少吃 一颗糖果。
 * 请你构建一个布尔型数组answer，满足answer.length == queries.length 。answer[i]为true的条件是：在每天吃 不超过 dailyCapi颗糖果的前提下，你可以在第favoriteDayi天吃到第favoriteTypei类糖果；否则 answer[i]为 false。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 * 请你返回得到的数组answer。
 *
 * 示例 1：
 *
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 *
 * 链接：https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day
 * ref: https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/solution/gong-shui-san-xie-qian-zhui-he-qiu-jie-c-b38y/
 */
public class EatCandies {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int m = candiesCount.length, n = queries.length;
        long[] sum = new long[m + 1];
        boolean[] ans = new boolean[n];
        for (int i = 1; i <= m; i++) {
            sum[i] = sum[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int t = queries[i][0], d = queries[i][1], c = queries[i][2];
            long min = sum[t] / c + 1, max = sum[t + 1];
            ans[i] = d >= min && d <= max;
        }
        return ans;
    }
}
