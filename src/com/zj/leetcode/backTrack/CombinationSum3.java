package com.zj.leetcode.backTrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created on 2020/9/11.
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 */
public class CombinationSum3 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> current = new ArrayDeque<>();

    combine(k, n, result, current, 1);
    return result;
  }

  private void combine(int k, int n, List<List<Integer>> res, Deque<Integer> cur, int curNum) {
    if (k == 0 && n == 0) {
      res.add(new ArrayList<>(cur));
      return;
    }
    if (k == 0 || n == 0) {
      return;
    }

    for (int i = curNum; i <= n && i < 10; i++) {
      cur.addLast(i);
      combine(k - 1, n - i, res, cur, i + 1);
      cur.removeLast();
    }
  }
}
