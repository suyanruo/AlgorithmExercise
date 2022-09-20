package com.zj.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @author: zhangjian
 * @date: 2022/9/20 16:07
 * @description: 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 链接：https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 * ref: https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/solution/by-ac_oier-mryw/
 */
public class CanPartitionKSubsets {
    int[] nums;
    int n, k, t;
    public boolean canPartitionKSubsets(int[] _nums, int _k) {
        nums = _nums; k = _k;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) return false;
        n = nums.length; t = sum / k;
        Arrays.sort(nums);
        return dfs(n - 1, 0, 0, new boolean[n]);
    }

    private boolean dfs(int index, int cur, int count, boolean[] vis) {
        if (count == k) return true;
        if (cur == t) return dfs(n - 1, 0, count + 1, vis);
        for (int i = index; i >= 0; i--) {
            if (vis[i] || cur + nums[i] > t) continue;
            vis[i] = true;
            if (dfs(i - 1, cur + nums[i], count, vis)) return true;
            vis[i] = false;
            if (cur == 0) return false;
        }
        return false;
    }
}
