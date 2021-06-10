package com.zj.leetcode.dynamic;

/**
 * Created by ZhangJian on 2021/6/10.
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 *
 * 链接：https://leetcode-cn.com/problems/coin-change
 * ref: https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-bei-bao-wen-ti-zhan-zai-3265/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int INF = 0x3f3f3f3f;
        int n = coins.length;
        int[] f = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            f[i] = INF;
        }
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int j = coin; j <= amount; j++) {
                f[j] = Math.min(f[j], f[j - coin] + 1);
            }
        }
        return f[amount] == INF ? -1 : f[amount];
    }
}
