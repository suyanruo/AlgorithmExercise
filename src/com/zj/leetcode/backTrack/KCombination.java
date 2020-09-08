package com.zj.leetcode.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/9/8.
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combinations
 */
public class KCombination {
  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> combine(int n, int k) {
    List<Integer> current = new ArrayList<>();
    combineKinN(n, k, current, 1);
    return result;
  }

  private void combineKinN(int n, int k, List<Integer> current, int currentNum) {
    if (current.size() == k) {
      result.add(current);
      return;
    }

    // TODO: 2020/9/8 可优化：搜索起点的上界 + 接下来要选择的元素个数 - 1 = n  ->  搜索起点的上界 = n - (k - path.size()) + 1
    for (int i = currentNum; i <= n; i++) {
      current.add(new Integer(i));
      combineKinN(n, k, current, i + 1);
      current.remove(new Integer(i));
    }
  }
}
