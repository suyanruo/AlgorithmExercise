package com.zj.leetcode.doublePointer;

/**
 * Created by ZhangJian on 2021/8/10.
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 *
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * ref: https://leetcode-cn.com/problems/arithmetic-slices/solution/gong-shui-san-xie-shuang-zhi-zhen-qiu-ji-ef1q/
 */
public class NumberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int l = nums.length;
        int ans = 0;
        for (int i = 0; i < l - 2;) {
            int j = i, d = nums[j + 1] - nums[j];
            while (j < l - 1 && nums[j + 1] - nums[j] == d) j++;
            int len = j - i + 1;
            // a1：长度为 len 的子数组数量；an：长度为 3 的子数组数量
            int a1 = 1, an = len - 3 + 1;
            // 符合条件（长度大于等于3）的子数组的数量为「差值数列求和」结果
            ans += (a1 + an) * an / 2;
            i = j;
        }
        return ans;
    }
}
