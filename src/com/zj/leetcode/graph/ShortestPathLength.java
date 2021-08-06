package com.zj.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ZhangJian on 2021/8/6.
 * 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
 * 给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 *
 * 链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes
 * ref: https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/solution/fang-wen-suo-you-jie-dian-de-zui-duan-lu-mqc2/
 */
public class ShortestPathLength {
    public int shortestPathLength(int[][] graph) {
        int l = graph.length;
        Deque<int[]> d = new ArrayDeque<>();
        boolean[][] seen = new boolean[l][1 << l];
        for (int i = 0; i < l; i++) {
            d.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        while (!d.isEmpty()) {
            int[] tuple = d.pollFirst();
            int u = tuple[0], mask = tuple[1], dis = tuple[2];
            if (mask == 1 << l - 1) {
                return dis;
            }
            // 搜索相邻的节点
            for (int v : graph[u]) {
                // 将 mask 的第 v 位置为 1
                int maskV = mask | 1 << v;
                if (!seen[v][maskV]) {
                    d.offer(new int[]{v, maskV, dis + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return 0;
    }
}
