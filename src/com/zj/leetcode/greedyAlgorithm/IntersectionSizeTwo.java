package com.zj.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @author: zhangjian
 * @date: 2022/7/22 14:33
 * @description: 设置交集大小至少为2
 * 一个整数区间[a, b](a < b) 代表着从a到b的所有连续整数，包括a和b。
 * 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
 * 输出这个最小集合S的大小。
 *
 * 链接：https://leetcode.cn/problems/set-intersection-size-at-least-two
 * ref: https://leetcode.cn/problems/set-intersection-size-at-least-two/solution/by-ac_oier-3xn6/
 */
public class IntersectionSizeTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int a = -1, b = -1, count = 0;
        for (int[] ints : intervals) {
            if (ints[0] > b) {
                a = ints[1] - 1; b = ints[1];
                count += 2;
            } else if (ints[0] > a) {
                a = b; b = ints[1];
                count++;
            }
        }
        return count;
    }
}
