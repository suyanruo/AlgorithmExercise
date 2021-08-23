package com.zj.leetcode.math;

/**
 * Created by ZhangJian on 2021/8/23.
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值。
 *
 * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
 */
public class MaximumGenerated {
    public int getMaximumGenerated(int n) {
        if (n <= 0) return 0;
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        int ans = 1;
        for (int i = 1; i <= n / 2; i++) {
            f[i * 2] = f[i];
            if (i * 2 + 1 <= n) {
                f[i * 2 + 1] = f[i] + f[i + 1];
                ans = Math.max(ans, f[i * 2 + 1]);
            } else {
                ans = Math.max(ans, f[i * 2]);
            }
        }
        return ans;
    }
}
