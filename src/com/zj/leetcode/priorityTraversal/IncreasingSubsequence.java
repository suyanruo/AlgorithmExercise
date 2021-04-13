package com.zj.leetcode.priorityTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created on 2020/8/25.
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 */
public class IncreasingSubsequence {

  public List<List<Integer>> findSubsequences(int[] nums) {
    Stack<Integer> cur = new Stack<>();
    HashMap<List<Integer>, List<Integer>> anwH = new HashMap();
    List<List<Integer>> anw = new ArrayList<>();
    dfsSequence(cur, anwH, -1, 0, nums);
    for (List<Integer> res : anwH.keySet()) {
      anw.add(res);
    }
    return anw;
  }

  private void dfsSequence(Stack<Integer> cur, HashMap<List<Integer>, List<Integer>> anw, int last, int pos, int[] nums) {
    if (nums.length == pos) {
      return;
    }
    if (cur.isEmpty() || cur.peek() <= nums[pos] && isFirst(last, pos, nums)) {
      cur.push(nums[pos]);
      if (cur.size() >= 2) {
        anw.put(new ArrayList<>(cur), new ArrayList<>(cur));
      }
      dfsSequence(cur, anw, pos, pos + 1, nums);
      cur.pop();
    }
    dfsSequence(cur, anw, last, pos + 1, nums);
  }


  private boolean isFirst(int last, int pos, int[] nums) {
    for (int i = last + 1; i < pos; i++) {
      if (nums[i] == nums[pos]) {
        return false;
      }
    }
    return true;
  }
}
