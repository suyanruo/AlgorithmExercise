package com.zj.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/9/13 19:59
 * @description: 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 链接：https://leetcode.cn/problems/maximum-swap/
 * ref: https://leetcode.cn/problems/maximum-swap/solution/by-ac_oier-jxmh/
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10); num /= 10;
        }
        int n = list.size();
        int[] arr = new int[n];
        for (int i = 0, j = 0; i < n; i++) {
            if (list.get(i) > list.get(j)) j = i;
            arr[i] = j;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(arr[i]) != list.get(i)) {
                int v = list.get(arr[i]);
                list.set(arr[i], list.get(i));
                list.set(i, v);
                break;
            }
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) ans = ans * 10 + list.get(i);
        return ans;
    }
}
