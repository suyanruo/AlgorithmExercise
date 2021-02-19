package com.zj.leetcode.doublePointer;

/**
 * Created on 2/19/21.
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 *
 * 参考：https://leetcode-cn.com/problems/max-consecutive-ones-iii/solution/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/
 */

public class LongestOnes {
  public int longestOnes(int[] A, int K) {
    int left = 0, right = 0;
    int len = 0;
    int zeroCount = 0;
    while (right < A.length) {
      if (A[right] == 0) {
        zeroCount++;
      }
      while (zeroCount > K) {
        if (A[left] == 0) {
          zeroCount--;
        }
        left++;
      }
      len = Math.max(right - left + 1, len);
      right++;
    }

    return len;
  }
}
