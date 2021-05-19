package com.zj.leetcode.bitOperation;

import java.util.PriorityQueue;

/**
 * Created by ZhangJian on 2021/5/19.
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 请你找出matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 * 示例 1：
 *
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 *
 * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
 *
 * ref: https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/solution/gong-shui-san-xie-xiang-jie-li-yong-er-w-ai0d/
 */
public class KthLargestValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] ^ sum[i][j - 1] ^ sum[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                if (queue.size() < k) {
                    queue.add(sum[i][j]);
                } else if (sum[i][j] > queue.peek()) {
                    queue.poll();
                    queue.add(sum[i][j]);
                }
            }
        }
        return queue.peek();
    }
}
