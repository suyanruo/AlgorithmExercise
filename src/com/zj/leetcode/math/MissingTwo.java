package com.zj.leetcode.math;

/**
 * @author: zhangjian
 * @date: 2022/9/26 15:48
 * @description: 面试题 17.19. 消失的两个数字
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 *
 * 链接: https://leetcode.cn/problems/missing-two-lcci/
 * ref: https://leetcode.cn/problems/missing-two-lcci/solution/by-ac_oier-pgeh/
 */
public class MissingTwo {
    public int[] missingTwo(int[] nums) {
        int size = nums.length + 2, cur = (1 + size) * size / 2;
        for (int num : nums) cur -= num;
        int mid = cur / 2, sum = cur;
        cur = (1 + mid) * mid / 2;
        for (int num : nums) {
            if (num <= mid) cur -= num;
        }
        return new int[] {cur, sum - cur};
    }
}
