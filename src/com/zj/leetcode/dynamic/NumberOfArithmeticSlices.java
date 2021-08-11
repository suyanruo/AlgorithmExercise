package com.zj.leetcode.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangJian on 2021/8/11.
 * 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 *
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence
 * ref: https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/solution/gong-shui-san-xie-xiang-jie-ru-he-fen-xi-ykvk/
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int l = nums.length;
        List<Map<Long, Integer>> f = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            Map<Long, Integer> cur = new HashMap<>();
            for (int j = 0; j < i; j++) {
                Map<Long, Integer> pre = f.get(j);
                long d = nums[i] * 1L - nums[j];
                int count = cur.getOrDefault(d, 0);
                count += pre.getOrDefault(d, 0);
                count++;
                cur.put(d, count);
            }
            f.add(cur);
        }
        int ans = 0;
        for (int i = 0; i < l; i++) {
            Map<Long, Integer> cur = f.get(i);
            for (int j : cur.values()) {
                ans += j;
            }
        }
        int a0 = 0, an = l - 1;
        int deleteCount = (a0 + an) * l / 2;
        return ans - deleteCount;
    }
}
