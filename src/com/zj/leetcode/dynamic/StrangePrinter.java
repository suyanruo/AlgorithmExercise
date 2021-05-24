package com.zj.leetcode.dynamic;

/**
 * Created by ZhangJian on 2021/5/24.
 * 有台奇怪的打印机有以下两个特殊要求：
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 *
 * 示例 1：
 *
 * 输入：s = "aaabbb"
 * 输出：2
 * 解释：首先打印 "aaa" 然后打印 "bbb"。
 * 示例 2：
 *
 * 输入：s = "aba"
 * 输出：2
 * 解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 *
 * 链接：https://leetcode-cn.com/problems/strange-printer
 * ref: https://leetcode-cn.com/problems/strange-printer/solution/xin-shou-pian-cong-xiao-wen-ti-zai-dao-q-qifh/
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        char[] cs = s.toCharArray();
        int l = s.length();
        int[][] dp = new int[l][l];
        for (int i = l - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int k = l - 1 - i + j;
                if (k == j) {
                    dp[j][k] = 1;
                } else {
                    if (cs[j] == cs[k]) {
                        dp[j][k] = dp[j][k - 1];
                    } else {
                        dp[j][k] = dp[j][j] + dp[j + 1][k];
                        for (int m = j + 1; m < k; m++) {
                            dp[j][k] = Math.min(dp[j][k], dp[j][m] + dp[m + 1][k]);
                        }
                    }
                }
            }
        }
        return dp[0][l - 1];
    }
}
