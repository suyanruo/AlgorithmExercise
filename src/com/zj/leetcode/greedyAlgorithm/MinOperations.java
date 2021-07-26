package com.zj.leetcode.greedyAlgorithm;

import java.util.*;

/**
 * Created by ZhangJian on 2021/7/26.
 * 给你一个数组target，包含若干 互不相同的整数，以及另一个整数数组arr，arr可能 包含重复元素。
 * 每一次操作中，你可以在 arr的任意位置插入任一整数。比方说，如果arr = [1,4,1,2]，那么你可以在中间添加 3得到[1,4,3,1,2]。你可以在数组最开始或最后面添加整数。
 * 请你返回 最少操作次数，使得target成为arr的一个子序列。
 * 一个数组的 子序列指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4]是[4,2,3,7,2,1,4]的子序列（加粗元素），但[2,4,2]不是子序列。
 *
 * 示例 1：
 *
 * 输入：target = [5,1,3], arr = [9,4,2,3,4]
 * 输出：2
 * 解释：你可以添加 5 和 1 ，使得 arr 变为 [5,9,4,1,2,3,4] ，target 为 arr 的子序列。
 *
 * 链接：https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence
 * ref: https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-oj7yu/
 */
public class MinOperations {
    public int minOperations(int[] target, int[] arr) {
        int m = target.length, n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            if (map.containsKey(x)) list.add(map.get(x));
        }
        int len = list.size();
        int[] f = new int[len];
        int[] g = new int[len + 1];
        Arrays.fill(g, Integer.MAX_VALUE);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (g[mid] < list.get(i)) l = mid;
                else r = mid - 1;
            }
            int cLen = r + 1;
            f[i] = cLen;
            g[cLen] = Math.min(g[cLen], list.get(i));
            ans = Math.max(ans, cLen);
        }
        return m - ans;
    }
}
