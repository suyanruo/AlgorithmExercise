package com.zj.leetcode.recursion;

/**
 * Created on 2020/9/1.
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 *
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * 链接：https://leetcode-cn.com/problems/predict-the-winner
 */
public class PredictWinner {
  public boolean PredictTheWinner(int[] nums) {
    return helper(nums, 0, nums.length - 1) > 0;
  }

  /**
   * 递归
   */
  private int helper(int[] nums, int start, int end) {
    if (start == end) {
      return nums[start];
    }
    int left = nums[start] - helper(nums, start + 1, end);
    int right = nums[end] - helper(nums, start, end - 1);
    return Math.max(left, right);
  }
}
