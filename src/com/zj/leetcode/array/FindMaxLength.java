package com.zj.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangJian on 2021/6/3.
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 *
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 *
 * ref: https://leetcode-cn.com/problems/contiguous-array/solution/gong-shui-san-xie-qian-zhui-he-ha-xi-bia-q400/
 *      https://blog.csdn.net/weixin_39784818/article/details/93567095
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        int sum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0 ? -1 : 1);
            if (sum == 0) {
                ans = Math.max(ans, i + 1);
            }
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
