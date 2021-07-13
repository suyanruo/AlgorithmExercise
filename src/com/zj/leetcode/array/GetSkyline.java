package com.zj.leetcode.array;

import java.util.*;

/**
 * Created by ZhangJian on 2021/7/13.
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
 * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
 *
 * lefti 是第 i 座建筑物左边缘的 x 坐标。
 * righti 是第 i 座建筑物右边缘的 x 坐标。
 * heighti 是第 i 座建筑物的高度。
 * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 *
 * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 *
 * 链接：https://leetcode-cn.com/problems/the-skyline-problem
 * ref: https://leetcode-cn.com/problems/the-skyline-problem/solution/gong-shui-san-xie-sao-miao-xian-suan-fa-0z6xc/
 */
public class GetSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> ps = new ArrayList<>();
        for (int[] build : buildings) {
            int l = build[0], r = build[1], h = build[2];
            ps.add(new int[]{l, -h});
            ps.add(new int[]{r, h});
        }
        Collections.sort(ps, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int pre = 0;
        q.add(pre);
        for (int[] i : ps) {
            int point = i[0], height = i[1];
            if (height < 0) {
                q.add(-height);
            } else {
                q.remove(height);
            }
            int cur = q.peek();
            if (pre != cur) {
                List<Integer> tem = new ArrayList<>();
                tem.add(point);
                tem.add(cur);
                ans.add(tem);
                pre = cur;
            }
        }
        return ans;
    }
}
