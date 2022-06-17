package com.zj.leetcode.binarySearch;

import java.util.Arrays;

/**
 * Created by zhangjian on 2022/6/15.
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 * 链接：https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 *
 * 参考：https://leetcode.cn/problems/find-k-th-smallest-pair-distance/solution/by-ac_oier-o4if/
 */
public class SmallestDistancePair {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = (int) 1e6;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, mid) >= k) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    private int check(int[] nums, int dis) {
        int n = nums.length, count = 0;
        for (int i = 0, j = 1; i < n; i++) {
            while (j < n && nums[j] - nums[i] <= dis) j++;
            count += j - i - 1;
        }
        return count;
    }
}
