package com.zj.leetcode.dynamic;

import java.util.Arrays;

/**
 * Created by zhangjian on 2022/6/10.
 * 给定一个字符串 s，返回 s 中不同的非空「回文子序列」个数 。
 * 通过从 s 中删除 0 个或多个字符来获得子序列。
 * 如果一个字符序列与它反转后的字符序列一致，那么它是「回文字符序列」。
 * 如果有某个 i , 满足 ai != bi ，则两个序列 a1, a2, ... 和 b1, b2, ... 不同。
 * 注意：结果可能很大，你需要对 109 + 7 取模 。
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] 仅包含 'a', 'b', 'c' 或 'd' 
 *
 * 链接：https://leetcode.cn/problems/count-different-palindromic-subsequences/
 *
 * 参考：https://leetcode.cn/problems/count-different-palindromic-subsequences/solution/by-ac_oier-lbva/
 */
public class CountPalindromicSubsequences {
    int MOD = (int)1e9+7;

    public int countPalindromicSubsequences(String s) {
        char[] cs = s.toCharArray();
        int n =  cs.length;
        int[][] f = new int[n][n];
        int[] L = new int[4];
        int[] R = new int[4];
        Arrays.fill(L, -1);
        for (int i = n - 1; i >= 0; i--) {
            L[cs[i] - 'a'] = i;
            Arrays.fill(R, -1);
            for (int j = i; j < n; j++) {
                R[cs[j] - 'a'] = j;
                for (int k = 0; k < 4; k++) {
                    int l = L[k], r = R[k];
                    if (l == -1 || r == -1) continue;
                    if (l == r) f[i][j] = (f[i][j] + 1) % MOD;
                    else if (l == r - 1) f[i][j] = (f[i][j] + 2) % MOD;
                    else f[i][j] = (f[i][j] + f[l + 1][r - 1] + 2) %MOD;
                }
            }
        }
        return f[0][n - 1];
    }
}
