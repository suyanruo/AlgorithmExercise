package com.zj.leetcode.array;

import java.util.Arrays;

/**
 * @author: zhangjian
 * @date: 2022/9/14 17:30
 * @description: 删除某些元素后的数组均值
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
 * 链接：https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 * ref: https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/solution/by-ac_oier-73w7/
 */
public class TrimMean {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, ans = 0;
        for (int i = n / 20; i < n - n / 20; i++) {
            ans += arr[i];
        }
        return ans / (n * 18.0 / 20.0);
    }
}
