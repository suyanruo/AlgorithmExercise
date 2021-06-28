package com.zj.leetcode.priorityTraversal;

import java.util.*;

/**
 * Created by ZhangJian on 2021/6/28.
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 * 示例 1：
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 *
 * 示例 2：
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *
 * 链接：https://leetcode-cn.com/problems/bus-routes
 * ref: https://leetcode-cn.com/problems/bus-routes/solution/gong-shui-san-xie-yi-ti-shuang-jie-po-su-1roh/
 */
public class NumBusesToDestination {
    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) {
                return 1;
            }
            int ans = bfs(routes, source, target);
            return ans;
        }

        private int bfs(int[][] routes, int source, int target) {
            // 站点-经过站点的路线
            HashMap<Integer, Set<Integer>> map = new HashMap<>();
            // 经过的路线
            Deque<Integer> d = new ArrayDeque<>();
            // 站点-乘坐线路数量
            HashMap<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < routes.length; i++) {
                for (int station : routes[i]) {
                    if (station == source) {
                        d.add(i);
                        m.put(i, 1);
                    }
                    Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                    set.add(i);
                    map.put(station, set);
                }
            }
            while (!d.isEmpty()) {
                int line = d.poll();
                int step = m.get(line);
                for (int station : routes[line]) {
                    if (station == target) {
                        return step;
                    }
                    Set<Integer> set = map.get(station);
                    if (set == null) {
                        continue;
                    }
                    for (int l : set) {
                        if (!m.containsKey(l)) {
                            d.add(l);
                            m.put(l, step + 1);
                        }
                    }
                }
            }
            return -1;
        }
    }
}
