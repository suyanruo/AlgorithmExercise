package com.zj.leetcode.backTrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created on 2020/9/18.
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 */
public class FullArray {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length == 0) {
      return result;
    }
    // 排序（升序或者降序都可以），排序是剪枝的前提
    Arrays.sort(nums);
    boolean[] used = new boolean[nums.length];
    // 使用 Deque 是 Java 官方 Stack 类的建议
    Deque<Integer> current = new ArrayDeque<>();
    dfs(nums, 0, result, used, current);
    return result;
  }

  private void dfs(int[] nums, int depth, List<List<Integer>> res, boolean[] used, Deque<Integer> cur) {
    if (depth == nums.length) {
      res.add(new ArrayList<>(cur));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
      // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择，
      // 为了防止写入num[i]后再写入num[i - 1]导致同样的list出现多次，所以对多个相同值的数组元素只能按下标顺序存入一次
      if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
        continue;
      }

      cur.addLast(nums[i]);
      used[i] = true;

      dfs(nums, depth + 1, res, used, cur);

      // 回溯
      cur.removeLast();
      used[i] = false;
    }
  }
}
