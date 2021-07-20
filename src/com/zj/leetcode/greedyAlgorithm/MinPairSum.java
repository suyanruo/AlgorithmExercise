package com.zj.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * Created by ZhangJian on 2021/7/20.
 * 一个数对(a,b)的 数对和等于a + b。最大数对和是一个数对数组中最大的数对和。
 * 比方说，如果我们有数对(1,5)，(2,3)和(4,4)，最大数对和为max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8。
 * 给你一个长度为 偶数n的数组nums，请你将 nums中的元素分成 n / 2个数对，使得：
 * nums中每个元素恰好在 一个数对中，且
 * 最大数对和的值 最小。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和。
 *
 * 示例 1：
 *
 * 输入：nums = [3,5,2,3]
 * 输出：7
 * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
 * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
 *
 * 链接：https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array
 * ref: https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-ru29y/
 */
public class MinPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int ans = 0;
        for (int i = 0; i < l / 2; i++) {
            ans = Math.max(ans, nums[i] + nums[l - 1 - i]);
        }
        return ans;
    }
}
