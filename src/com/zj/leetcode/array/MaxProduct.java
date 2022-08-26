package com.zj.leetcode.array;

/**
 * @author: zhangjian
 * @date: 2022/8/26 14:05
 * @description: 数组中两元素的最大乘积
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 *
 * 链接：https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
            } else if (nums[i] > b) {
                b = nums[i];
            }
        }
        return (a - 1) * (b - 1);
    }
}
