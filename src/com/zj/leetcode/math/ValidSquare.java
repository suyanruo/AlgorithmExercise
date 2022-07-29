package com.zj.leetcode.math;

import java.util.Arrays;

/**
 * @author: zhangjian
 * @date: 2022/7/29 10:41
 * @description: 有效的正方形
 * 给定2D空间中四个点的坐标p1,p2,p3和p4，如果这四个点构成一个正方形，则返回 true 。
 * 点的坐标pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 *
 * 链接：https://leetcode.cn/problems/valid-square
 * https://leetcode.cn/problems/valid-square/solution/by-ac_oier-lwdf/
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (Arrays.equals(p1, p2) && Arrays.equals(p1, p3) && Arrays.equals(p1, p4)) return false;
        int[][] a = new int[][] {p1, p2, p3, p4};
        // 对正方形从左上角往右下角排序，排序后的数组首尾结点必然是对角线上的两个点。
        Arrays.sort(a, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[] q1 = a[0], q2 = a[1], q3 = a[2], q4 = a[3];
        // 判断头结点与相邻结点距离是否相等，尾结点与相邻结点距离是否相等
        if (Math.abs(q2[0] - q1[0]) != Math.abs(q3[1] - q1[1])
                || Math.abs(q2[1] - q1[1]) != Math.abs(q3[0] - q1[0])
                || Math.abs(q4[0] - q2[0]) != Math.abs(q4[1] - q3[1])
                || Math.abs(q4[1] - q2[1]) != Math.abs(q4[0] - q3[0])) {
            return false;
        }
        // 判断对角线两结点距离是否都相同
        if (Math.abs(q4[0] - q1[0]) != Math.abs(q3[1] - q2[1])
                || Math.abs(q4[1] - q1[1]) != Math.abs(q3[0] - q2[0])) {
            return false;
        }
        return true;
    }
}
