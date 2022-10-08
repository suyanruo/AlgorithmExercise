package com.zj.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author: zhangjian
 * @date: 2022/10/8 15:14
 * @description: 优势洗牌
 * 给定两个大小相等的数组nums1和nums2，nums1相对于 nums2 的优势可以用满足nums1[i] > nums2[i]的索引 i的数目来描述。
 * 返回 nums1的任意排列，使其相对于 nums2的优势最大化。
 *
 * 链接：https://leetcode.cn/problems/advantage-shuffle
 * ref: https://leetcode.cn/problems/advantage-shuffle/solution/by-ac_oier-i01s/
 */
public class AdvantageCount {
    class  Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            TreeSet<Integer> set = new TreeSet<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums1) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                if (map.get(i) == 1) set.add(i);
            }
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                Integer cur = set.ceiling(nums2[i] + 1);
                if (cur == null) cur = set.ceiling(0);
                ans[i] = cur;
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) set.remove(cur);
            }
            return ans;
        }
    }

}
