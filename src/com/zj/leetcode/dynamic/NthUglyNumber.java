package com.zj.leetcode.dynamic;

import java.util.Arrays;

/**
 * Created on 4/11/21.
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 *
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 *
 * ref: https://leetcode-cn.com/problems/ugly-number-ii/solution/fu-xue-ming-zhu-gai-shui-cheng-yi-2-3-5-92zlw/
 */

public class NthUglyNumber {
  public int nthUglyNumber(int n) {
    int[] uglyArr = new int[n];
    Arrays.fill(uglyArr, 1);
    int index2 = 0, index3 = 0, index5 = 0;
    for (int i = 1; i < n; i++) {
      uglyArr[i] = findMin(uglyArr[index2] * 2, uglyArr[index3] * 3, uglyArr[index5] * 5);
      if (uglyArr[i] == uglyArr[index2] * 2) {
        index2++;
      }
      if (uglyArr[i] == uglyArr[index3] * 3) {
        index3++;
      }
      if (uglyArr[i] == uglyArr[index5] * 5) {
        index5++;
      }
    }
    for (int i = 0; i < n; i++) {
      System.out.println(uglyArr[i]);
    }
    return uglyArr[n - 1];
  }

  private int findMin(int a, int b, int c) {
    int min = Math.min(a, b);
    min = Math.min(min, c);
    return min;
  }
}
