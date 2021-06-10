package com.zj.leetcode.dynamic;

/**
 * Created by ZhangJian on 2021/6/10.
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 * 示例 1:
 *
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * ref: https://leetcode-cn.com/problems/coin-change-2/solution/gong-shui-san-xie-xiang-jie-wan-quan-bei-6hxv/
 */
public class CoinChangeII {
    public class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] f = new int[n + 1][amount + 1];
            f[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int coin = coins[i - 1];
                for (int j = 0; j <= amount; j++) {
                    f[i][j] = f[i - 1][j];
                    for (int k = 1; k <= j / coin; k++) {
                        f[i][j] += f[i - 1][j - k * coin];
                    }
                }
            }
            return f[n][amount];
        }
    }

    public class Solution2 {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[] f = new int[amount + 1];
            f[0] = 1;
            for (int i = 1; i <= n; i++) {
                int coin = coins[i - 1];
                for (int j = coin; j <= amount; j++) {
                    f[j] += f[j - coin];
                }
            }
            return f[amount];
        }
    }
}
