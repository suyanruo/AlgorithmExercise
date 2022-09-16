package com.zj.leetcode.simulation;

import java.util.*;

/**
 * @author: zhangjian
 * @date: 2022/9/16 18:16
 * @description: 矩形面积 II
 * 我们给出了一个（轴对齐的）二维矩形列表rectangles。 对于rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是矩形i左下角的坐标，(xi1, yi1)是该矩形 左下角 的坐标，(xi2, yi2)是该矩形右上角 的坐标。
 * 计算平面中所有rectangles所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。
 * 返回 总面积 。因为答案可能太大，返回109+ 7 的模。
 *
 * 链接：https://leetcode.cn/problems/rectangle-area-ii
 * ref: https://leetcode.cn/problems/rectangle-area-ii/solution/gong-shui-san-xie-by-ac_oier-9r36/
 */
public class RectangleArea {
    int MOD = (int) (1e9 + 7);

    public int rectangleArea(int[][] rs) {
        List<Integer> list = new ArrayList<>();
        for (int[] r : rs) {
            list.add(r[0]); list.add(r[2]);
        }
        Collections.sort(list);
        long ans = 0;
        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i - 1), b = list.get(i), len = b - a;
            if (len == 0) continue;
            List<int[]> lines = new ArrayList<>();
            for (int[] r : rs) {
                if (r[0] <= a && b <= r[2]) {
                    lines.add(new int[] {r[1], r[3]});
                }
            }
            Collections.sort(lines, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
            long l = -1, r = -1, h = 0;
            for (int[] cur : lines) {
                if (cur[0] > r) {
                    h += r - l;
                    l = cur[0];
                    r = cur[1];
                } else if (cur[1] > r) {
                    r = cur[1];
                }
            }
            h += r - l;
            ans = (ans + len * h) % MOD;
        }
        return (int) ans;
    }
}
