package com.zj.leetcode.array;

/**
 * Created by ZhangJian on 2021/7/9.
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * ref: https://leetcode-cn.com/problems/find-majority-element-lcci/solution/gong-shui-san-xie-yi-ti-shuang-jie-ha-xi-zkht/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = 0, count = 0;
        for (int i : nums) {
            if (i == n) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    n = i;
                    count = 1;
                }
            }
        }
        count = 0;
        for (int i : nums) {
            if (i == n) {
                count++;
            }
        }
        return count > nums.length / 2 ? n : -1;
    }
}
