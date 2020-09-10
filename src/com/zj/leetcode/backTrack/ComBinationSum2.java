package com.zj.leetcode.backTrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created on 2020/9/10.
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
public class ComBinationSum2 {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);

    Deque<Integer> current = new ArrayDeque<>();
    combine(candidates, target, result, current, 0);
    return result;
  }

  private void combine(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> cur, int curIndex) {
    if (target == 0) {
      res.add(new ArrayList<>(cur));
      return;
    }

    for (int i = curIndex; i < candidates.length; i++) {
      if (candidates[i] > target) {
        break;
      }
      if (i > curIndex && candidates[i] == candidates[i - 1]) {
        continue;
      }
      cur.addLast(candidates[i]);
      combine(candidates, target - candidates[i], res, cur, i + 1);
      cur.removeLast();
    }
  }
}
