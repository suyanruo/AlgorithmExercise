package com.zj.leetcode.dynamic;

/**
 * @author: zhangjian
 * @date: 2022/7/10 15:18
 * @description: 摘樱桃
 * 一个N x N的网格(grid)代表了一块樱桃地，每个格子由以下三种数字的一种来表示：
 *
 * 0 表示这个格子是空的，所以你可以穿过它。
 * 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
 * -1 表示这个格子里有荆棘，挡着你的路。
 * 你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃：
 *
 * 从位置(0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）；
 * 当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
 * 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）；
 * 如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。
 *
 * 链接：https://leetcode.cn/problems/cherry-pickup
 * ref: https://leetcode.cn/problems/cherry-pickup/solution/by-ac_oier-pz7i/
 */
public class CherryPickup {
    int N = 55; int MIN = Integer.MIN_VALUE;
    int[][][] f = new int[2* N][N][N];

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        for (int k = 0; k <= 2 * n; k++) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    f[k][i][j] = MIN;
                }
            }
        }
        f[2][1][1] = grid[0][0];
        for (int k = 3; k <= 2 * n; k++) {
            for (int i1 = 1; i1 <= n; i1++) {
                for (int i2 = 1; i2 <= n; i2++) {
                    int j1 = k - i1, j2 = k - i2;
                    if (j1 <= 0 || j1 > n || j2 <= 0 || j2 > n) continue;
                    int gv1 = grid[i1 - 1][j1 - 1], gv2 = grid[i2 - 1][j2 - 1];
                    if (gv1 == -1 || gv2 == -1) continue;
                    int a = f[k - 1][i1 - 1][i2 - 1], b = f[k - 1][i1 - 1][i2], c = f[k - 1][i1][i2 - 1], d = f[k - 1][i1][i2];
                    int max = Math.max(Math.max(a, b), Math.max(c, d)) + gv1;
                    if (i1 != i2) max += gv2;
                    f[k][i1][i2] = max;
                }
            }
        }
        return f[2 * n][n][n] <= 0 ? 0 : f[2 * n][n][n];
    }
}
