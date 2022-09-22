package com.zj.leetcode.array;

/**
 * @author: zhangjian
 * @date: 2022/9/22 15:29
 * @description: 能否连接形成数组
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 * 链接：https://leetcode.cn/problems/check-array-formation-through-concatenation
 * ref: https://leetcode.cn/problems/check-array-formation-through-concatenation/solution/by-ac_oier-3jqf/
 */
public class CanFormArray {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int[] piece : pieces) {
            int i;
            for (i = 0; i < arr.length; i++) {
                if (arr[i] == piece[0]) break;
            }
            for (int p : piece) {
                if (i >= arr.length || p != arr[i++]) return false;
            }
        }
        return true;
    }
}
