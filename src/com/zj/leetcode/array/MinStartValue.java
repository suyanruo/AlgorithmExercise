package com.zj.leetcode.array;

/**
 * @author: zhangjian
 * @date: 2022/8/9 11:31
 * @description: 逐步求和得到正数的最小值
 * 给你一个整数数组 nums。你可以选定任意的正数 startValue 作为初始值。
 * 你需要从左到右遍历 nums数组，并将 startValue 依次累加上nums数组中的值。
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的正数作为 startValue 。
 *
 * 链接：https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum
 * ref: https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/solution/by-ac_oier-qo4e/
 */
public class MinStartValue {
    public int minStartValue(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i : nums) {
            sum += i;
            min = Math.min(min, sum);
        }
        return min >= 0 ? 1 : -min + 1;
    }
}
