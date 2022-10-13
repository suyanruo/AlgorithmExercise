package com.zj.leetcode.simulation;

/**
 * @author: zhangjian
 * @date: 2022/10/13 15:03
 * @description:  最多能完成排序的块
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * 返回数组能分成的最多块数量。
 *
 * 链接：https://leetcode.cn/problems/max-chunks-to-make-sorted
 * ref: https://leetcode.cn/problems/max-chunks-to-make-sorted/solution/by-ac_oier-4uny/
 */
public class MaxChunksToSorted {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, ans = 0;
        for (int i = 0, j = 0, min = n, max = -1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (i == max && j == min) {
                ans++; j = i + 1; min = n; max = -1;
            }
        }
        return ans;
    }
}
