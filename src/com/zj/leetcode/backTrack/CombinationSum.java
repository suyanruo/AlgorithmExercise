package com.zj.leetcode.backTrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created on 2020/9/9.
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class CombinationSum {
  private List<List<Integer>> sumList = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Deque<Integer> curSum = new ArrayDeque<>();
    combine(candidates, target, curSum, 0);
    return sumList;
  }

  private void combine(int[] candidates, int target, Deque<Integer> curSum, int curIndex) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      sumList.add(new ArrayList<>(curSum));
      return;
    }

    for (int i = curIndex; i < candidates.length; i++) {
      curSum.addLast(candidates[i]);
      combine(candidates, target - candidates[i], curSum, i);
      curSum.removeLast();
    }
  }
}
