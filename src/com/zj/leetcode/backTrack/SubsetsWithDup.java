package com.zj.leetcode.backTrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created on 3/31/21.
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 *
 * 参考：https://leetcode-cn.com/problems/subsets-ii/solution/zi-ji-ii-by-leetcode-solution-7inq/
 */

public class SubsetsWithDup {
  private List<List<Integer>> result;

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    result = new ArrayList<>();
    // 还可以考虑使用HashSet去重
    Deque<Integer> subList = new ArrayDeque<>();
    Arrays.sort(nums);
    dfs(nums, subList, 0);
    return result;
  }

  private void dfs(int[] nums, Deque<Integer> subList, int index) {
    if (index == nums.length) {
      result.add(new ArrayList<>(subList));
      return;
    }
    subList.addLast(nums[index]);
    // 选择当前的数
    dfs(nums, subList, index + 1);

    subList.removeLast();
    // 去重，不选当前数递归时直接跳过重复数
    while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
      // 所有重复数的可能性在前面递归中均会出现
      index++;
    }
    // 不选择当前的数
    dfs(nums, subList, index + 1);
  }
}
