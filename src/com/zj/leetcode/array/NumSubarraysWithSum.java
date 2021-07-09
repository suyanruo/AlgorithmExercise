package com.zj.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangJian on 2021/7/8.
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 *
 * 示例 1：
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *
 * 示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *
 * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
 * ref: https://leetcode-cn.com/problems/binary-subarrays-with-sum/solution/gong-shui-san-xie-yi-ti-shuang-jie-qian-hfoc0/
 */
public class NumSubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = nums[i - 1] + sum[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int r = sum[i], l = goal - r;
            ans += map.getOrDefault(l, 0);
            System.out.println("i = " + i + ", l size = " + map.getOrDefault(l, 0));
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return ans;
    }
}
