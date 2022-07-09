package com.zj.leetcode.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangjian
 * @date: 2022/7/9 17:01
 * @description: 最长的斐波那契子序列的长度
 * 如果序列X_1, X_2, ..., X_n满足下列条件，就说它是斐波那契式的：
 *
 * n >= 3
 * 对于所有i + 2 <= n，都有X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列 arr，找到 arr中最长的斐波那契式的子序列的长度。如果一个不存在，返回0 。
 * （回想一下，子序列是从原序列 arr中派生出来的，它从 arr中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如，[3, 5, 8]是[3, 4, 5, 6, 7, 8]的一个子序列）
 *
 * 链接：https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence
 * ref: https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/solution/by-ac_oier-beo2/
 */
public class LenLongestFibSubseq {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(arr[i], i);
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && j + 2 > res; j--) {
                int t = arr[i] - arr[j];
                if (t >= arr[j]) break;
                int idx = map.getOrDefault(t, -1);
                if (idx == -1) continue;
                f[i][j] = Math.max(3, f[j][t] + 1);
                res = Math.max(res, f[i][j]);
            }
        }
        return res;
    }
}
