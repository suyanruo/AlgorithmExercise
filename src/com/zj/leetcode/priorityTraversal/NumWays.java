package com.zj.leetcode.priorityTraversal;

import java.util.*;

/**
 * Created by ZhangJian on 2021/7/1.
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * 示例 1：
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * 输出：3
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 *
 * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi
 * ref: https://leetcode-cn.com/problems/chuan-di-xin-xi/solution/gong-shui-san-xie-tu-lun-sou-suo-yu-dong-cyxo/
 */
public class NumWays {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.numWays(5,
                new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}}
        ,3);
    }

    /**
     * 广度优先遍历
     */
    static class Solution {
        public int numWays(int n, int[][] relation, int k) {
            return bfs(n, relation, k);
        }

        private int bfs(int n, int[][] relation, int k) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < relation.length; i++) {
                int a = relation[i][0], b = relation[i][1];
                Set<Integer> s = map.getOrDefault(a, new HashSet<>());
                s.add(b);
                map.put(a, s);
            }
            System.out.println("map size: " + map.size());
            Deque<Integer> d = new ArrayDeque<>();
            d.add(0);
            while (!d.isEmpty() && k-- > 0) {
                int size = d.size();
                while (size-- > 0) {
                    int poll = d.poll();
                    Set<Integer> set = map.get(poll);
                    if (set == null) continue;
                    for (int next : set) {
                        d.addLast(next);
                    }
                }
            }
            int ans = 0;
            System.out.println(d.size());
            for (int i : d) {
                if (i == n - 1) ans++;
                System.out.print(i + "  ");
            }
            return ans;
        }
    }

    /**
     * 深度优先遍历
     */
    static class Solution2 {
        private int ans = 0;
        private int sn;
        private int[][] sr;
        private int sk;
        private Map<Integer, Set<Integer>> map;

        public int numWays(int n, int[][] relation, int k) {
            sn = n;
            sr = relation;
            sk = k;
            map = new HashMap<>();
            for (int[] r : relation) {
                int a = r[0], b= r[1];
                Set<Integer> s = map.getOrDefault(a, new HashSet<>());
                s.add(b);
                map.put(a, s);
            }
            dfs(0, 0);
            return ans;
        }

        private void dfs(int index, int step) {
            if (step == sk) {
                if (index == sn - 1) ans++;
                return;
            }
            Set<Integer> set = map.get(index);
            if (set == null) return;
            for (int next : set) {
                dfs(next, step + 1);
            }
        }
    }

    /**
     * 动态规划
     */
    class Solution3 {
        public int numWays(int n, int[][] relation, int k) {
            int[][] f = new int[k + 1][n];
            f[0][0] = 1;
            for (int i = 1; i <= k; i++) {
                for (int[] r : relation) {
                    int a = r[0], b = r[1];
                    f[i][b] += f[i - 1][a];

                }
            }
            return f[k][n - 1];
        }
    }
}
