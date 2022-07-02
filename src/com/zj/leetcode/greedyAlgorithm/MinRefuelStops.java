package com.zj.leetcode.greedyAlgorithm;

import java.util.PriorityQueue;

/**
 * @author: zhangjian
 * @date: 2022/7/3 00:20
 * @description: 最低加油次数
 * 汽车从起点出发驶向目的地，该目的地位于出发位置东面 target英里处。
 * 沿途有加油站，每个station[i]代表一个加油站，它位于出发位置东面station[i][0]英里处，并且有station[i][1]升汽油。
 * 假设汽车油箱的容量是无限的，其中最初有startFuel升燃料。它每行驶 1 英里就会用掉 1 升汽油。
 * 当汽车到达加油站时，它可能停下来加油，将所有汽油从加油站转移到汽车中。
 * 为了到达目的地，汽车所必要的最低加油次数是多少？如果无法到达目的地，则返回 -1 。
 * 注意：如果汽车到达加油站时剩余燃料为 0，它仍然可以在那里加油。如果汽车到达目的地时剩余燃料为 0，仍然认为它已经到达目的地。
 *
 * 链接：https://leetcode.cn/problems/minimum-number-of-refueling-stops
 * 参考：https://leetcode.cn/problems/minimum-number-of-refueling-stops/solution/by-ac_oier-q2mk/
 */
public class MinRefuelStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int remain = startFuel, loc = 0, staIndex = 0, res = 0;
        while (loc < target) {
            if (remain == 0) {
                if (!queue.isEmpty()) {
                    remain = queue.poll();
                    res++;
                }
                else return -1;

            }
            loc += remain; remain = 0;
            while (staIndex < stations.length && stations[staIndex][0] < loc) queue.add(stations[staIndex++][1]);
        }
        return res;
    }
}
