package com.zj.leetcode.math;

/**
 * @author: zhangjian
 * @date: 2022/8/23 13:53
 * @description: 变为棋盘
 * 一个n x n的二维网络board仅由0和1组成。每次移动，你能任意交换两列或是两行的位置。
 * 返回 将这个矩阵变为 “棋盘”所需的最小移动次数。如果不存在可行的变换，输出 -1。
 * “棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。
 *
 * 链接：https://leetcode.cn/problems/transform-to-chessboard
 * ref: https://leetcode.cn/problems/transform-to-chessboard/solution/by-ac_oier-vf1m/
 */
public class MovesToChessboard {
    private int n = 0, INF = 0x3f3f3f3f;

    public int movesToChessboard(int[][] g) {
        n = g.length;
        int r1 = -1, r2 = -1, c1 = -1, c2 = -1, mask = (1 << n) - 1;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) a |= (1 << j);
                if (g[j][i] == 1) b |= (1 << j);
            }
            if (r1 == -1) r1 = a;
            else if (r2 == -1 && a != r1) r2 = a;
            if (c1 == -1) c1 = b;
            else if (c2 == -1 && b != c1) c2 = b;
            if (a != r1 && a != r2) return -1;
            if (b != c1 && b != c2) return -1;
        }
        if (Integer.bitCount(r1) + Integer.bitCount(r2) != n) return -1;
        if (Integer.bitCount(c1) + Integer.bitCount(c2) != n) return -1;
        if ((r1 ^ r2) != mask || (c1 ^ c2) != mask) return -1;
        int t = 0;
        for (int i = 0; i < n; i += 2) t += (1 << i);
        int ans = Math.min(getCount(r1, t), getCount(r2, t)) + Math.min(getCount(c1, t), getCount(c2, t));
        return ans >= INF ? -1 : ans;
    }

    private int getCount(int a, int b) {
        int m1 = 0, m2 = 0;
        for (int i = 0; i < n; i++) {
            m1 += ((a >> i) & 1); m2 += ((b >> i) & 1);
        }
        return m1 != m2 ? INF : Integer.bitCount(a ^ b) / 2;
    }
}
