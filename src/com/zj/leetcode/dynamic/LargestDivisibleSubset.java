package com.zj.leetcode.dynamic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created on 4/23/21.
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 *
 * ref: https://leetcode-cn.com/problems/largest-divisible-subset/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-0a3jc/
 */

public class LargestDivisibleSubset {
  public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
      int n = nums.length;
      int[] f = new int[n];
      int[] g = new int[n];
      for (int i = 0; i < n; i++) {
        // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
        int len = 1, pre = i;
        for (int j = 0; j < i; j++) {
          if (nums[i] % nums[j] == 0) {
            // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
            if (f[j] + 1 > len) {
              len = f[j] + 1;
              pre = j;
            }
          }
        }
        // 记录「最终长度」&「从何转移而来」
        f[i] = len;
        g[i] = pre;
      }

      // 遍历所有的 f[i]，取得「最大长度」和「对应下标」
      int max = -1, index = -1;
      for (int i = 0; i < n; i++) {
        if (f[i] > max) {
          max = f[i];
          index = i;
        }
      }

      // 使用 g[] 数组回溯出具体方案
      List<Integer> ans = new ArrayList<>();
      while (ans.size() < max) {
        ans.add(0, nums[index]);
        index = g[index];
      }
      return ans;
    }
  }

  public class Solution2 {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
      Deque<Integer> deque = new ArrayDeque<>();
      Arrays.sort(nums);
      dfs(nums, deque, 0);
      return result;
    }

    private void dfs(int[] nums, Deque<Integer> deque, int index) {
      if (index == nums.length) {
        if (deque.size() > result.size()) {
          result.clear();
          result.addAll(new ArrayList<>(deque));
        }
        return;
      }
      boolean isAdded;
      for (int i = index; i < nums.length; i++) {
        isAdded = false;
        if (deque.isEmpty() || nums[i] % deque.peekLast() == 0) {
          deque.add(nums[i]);
          isAdded = true;
        }
        dfs(nums, deque, i + 1);
        if (isAdded) {
          deque.removeLast();
        }
      }
    }
  }
}
