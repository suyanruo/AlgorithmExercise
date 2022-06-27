package com.zj.leetcode.dynamic;

/**
 * @author: zhangjian
 * @date: 2022/6/27 13:28
 * @description: 最长特殊序列 II
 * 给定字符串列表strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * s的子序列可以通过删去字符串s中的某些字符实现。
 * 例如，"abc"是 "aebdc"的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc"。"aebdc"的子序列还包括"aebdc"、 "aeb"和 ""(空字符串)。
 *
 * 链接：https://leetcode.cn/problems/longest-uncommon-subsequence-ii
 * 参考：https://leetcode.cn/problems/longest-uncommon-subsequence-ii/solution/by-ac_oier-vuez/
 */
public class FindLUSlength {
    public int findLUSlength(String[] strs) {
        int l = strs.length, result = -1;
        for (int i = 0; i < l; i++) {
            if (strs[i].length() <= result) continue;
            boolean ok = true;
            for (int j = 0; j < l && ok; j++) {
                if (i == j) continue;
                if (check(strs[i], strs[j])) ok = false;
            }
            if (ok) result = strs[i].length();
        }
        return result;
    }

    private boolean check(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = f[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 : 0);
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                if (f[i][j] == m) return true;
            }
        }
        return false;
    }
}
