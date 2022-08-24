package com.zj.leetcode.array;

/**
 * @author: zhangjian
 * @date: 2022/8/24 10:14
 * @description: 通过翻转子数组使两个数组相等
 * 给你两个长度相同的整数数组target和arr。每一步中，你可以选择arr的任意 非空子数组并将它翻转。你可以执行此过程任意次。
 * 如果你能让 arr变得与 target相同，返回 True；否则，返回 False 。
 *
 * 链接：https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays
 * ref: https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/solution/by-ac_oier-pv38/
 */
public class CanBeEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length, count = 0;
        int[] counter = new int[1010];
        for (int i = 0; i < n; i++) {
            if (++counter[target[i]] == 1) count++;
            if (--counter[arr[i]] == 0) count--;
        }
        return count == 0;
    }
}
