package com.zj.leetcode.string;

/**
 * @author: zhangjian
 * @date: 2022/9/27 16:10
 * @description: 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 链接: https://leetcode.cn/problems/check-permutation-lcci/
 * ref: https://leetcode.cn/problems/check-permutation-lcci/solution/by-ac_oier-qj3j/
 */
public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n != m) return false;
        int[] counts = new int[256];
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (++counts[s1.charAt(i)] == 1) t++;
            if (--counts[s2.charAt(i)] == 0) t--;
        }
        return t == 0;
    }
}
