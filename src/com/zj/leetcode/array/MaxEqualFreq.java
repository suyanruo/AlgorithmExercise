package com.zj.leetcode.array;

import java.util.Arrays;

/**
 * @author: zhangjian
 * @date: 2022/8/18 10:10
 * @description: 最大相等频率
 * 给你一个正整数数组nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
 * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 *
 * 链接：https://leetcode.cn/problems/maximum-equal-frequency
 * ref: https://leetcode.cn/problems/maximum-equal-frequency/solution/by-ac_oier-fviv/
 */
public class MaxEqualFreq {
    public int maxEqualFreq(int[] nums) {
        int[] count = new int[100010], sum = new int[100010];
        Arrays.fill(count, 0);Arrays.fill(sum, 0);
        int n = nums.length, max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i], cur = ++count[num], len = i + 1;
            sum[cur]++;sum[cur - 1]--;
            max = Math.max(max, cur);
            if (max == 1) ans = len;
            if (max * sum[max] + 1 == len) ans = len;
            if ((max - 1) * (sum[max - 1] + 1) + 1 == len) ans = len;
        }
        return ans;
    }
}
