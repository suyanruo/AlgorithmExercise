package com.zj.leetcode.graph;

import java.util.*;

/**
 * Created by ZhangJian on 2021/8/5.
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是graph的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 *
 * 链接：https://leetcode-cn.com/problems/find-eventual-safe-states
 * ref: https://leetcode-cn.com/problems/find-eventual-safe-states/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-isy6u/
 */
public class EventualSafeNodes {
    private int N = (int) (1e4 + 10), M = 4 * N;
    private int index = 0;
    private int[] he = new int[N], e = new int[M], ne = new int[M];
    private int[] count = new int[N];

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Arrays.fill(he, -1);
        int l = graph.length;
        // 存反向图，并统计入度
        for (int i = 0; i < l; i++) {
            for (int j : graph[i]) {
                add(j, i);
                count[i]++;
            }
        }
        // BFS 求反向图拓扑排序
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            if (count[i] == 0) {
                d.addLast(i);
            }
        }
        while (!d.isEmpty()) {
            int poll = d.pollFirst();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--count[j] == 0) {
                    d.addLast(j);
                }
            }
        }
        // 遍历答案：如果某个节点出现在拓扑序列，说明其进入过队列，说明其入度为 0
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            if (count[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    private void add(int a, int b) {
        e[index] = b;
        ne[index] = he[a];
        he[a] = index++;
    }
}
