package com.zj.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangjian on 2022/6/16.
 *
 * 给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 * k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * 链接：https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 * 参考：https://leetcode.cn/problems/k-diff-pairs-in-an-array/solution/by-ac_oier-ap3v/
 */
public class FindPairs {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int i : nums) {
            if (map.get(i) == 0) continue;
            if (k == 0) {
                if (map.get(i) > 1)
                    count++;
            } else {
                if (map.getOrDefault(i - k, 0) > 0) count++;
                if (map.getOrDefault(i + k, 0) > 0) count++;
            }
            map.put(i, 0);
        }
        return count;
    }
}
