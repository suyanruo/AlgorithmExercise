package com.zj.leetcode.dynamic;

import java.util.Arrays;

/**
 * Created by ZhangJian on 2021/8/24.
 * 有 n 个城市通过一些航班连接。给你一个数组flights ，其中flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 *
 * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
 * ref: https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/solution/gong-shui-san-xie-xiang-jie-bellman-ford-dc94/
 */
public class CheapestPrice {
    private static int N = 110;
    private static int INF = 0x3f3f3f3f;
    private int[][] g = new int[N][N];
    private int[] dist = new int[N];

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                g[i][j] = i == j ? 0 : INF;
            }
        }
        for (int[] f : flights) {
            g[f[0]][f[1]] = f[2];
        }
        int ans = bf(n, src, dst, k + 1);
        return ans > INF / 2 ? -1 : ans;
    }

    private int bf(int n, int s, int d, int k) {
        Arrays.fill(dist, INF);
        dist[s] = 0;
        for (int c = 0; c < k; c++) {
            int[] clone = dist.clone();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[j] = Math.min(dist[j], clone[i] + g[i][j]);
                }
            }
        }
        return dist[d];
    }
}
