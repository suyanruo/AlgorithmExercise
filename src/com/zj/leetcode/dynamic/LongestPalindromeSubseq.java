package com.zj.leetcode.dynamic;

/**
 * Created by ZhangJian on 2021/8/12.
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * 示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 *
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * ref: https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/gong-shui-san-xie-qu-jian-dp-qiu-jie-zui-h2ya/
 */
public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[][] f = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                if (len == 1) {
                    f[l][r] = 1;
                } else if (len == 2) {
                    f[l][r] = (cs[l] == cs[r]) ? 2 : 1;
                } else {
                    f[l][r] = Math.max(f[l + 1][r], f[l][r - 1]);
                    f[l][r] = Math.max(f[l][r], f[l + 1][r - 1] + (cs[l] == cs[r] ? 2 : 0));
                }
            }
        }
        return f[0][n - 1];
    }
}
