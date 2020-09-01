package com.zj.leetcode.dynamic;

/**
 * Created on 2020/9/1.
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 */
public class DifferentNumInBit {
  public int countNumbersWithUniqueDigits(int n) {
    if (n == 0) return 0;
    int countSum = 10;
    if (n == 1) return countSum;
    int digitCount = Math.min(n, 9);
    int temp = 9;
    for (int i = 1; i < digitCount; i++) {
      temp *= 10 - i;
      countSum += temp;
    }
    return countSum;
  }
}
