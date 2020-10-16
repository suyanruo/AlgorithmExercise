package com.zj.leetcode.array;

/**
 * Created on 2020/10/16.
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * 排序：https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/ge-chong-pai-xu-shuang-zhi-zhen-by-toxic-3/
 */
public class SortedSquares {

  public int[] sortedSquares(int[] A) {
    for (int i = 0; i < A.length; i++) {
      A[i] = (int) Math.pow(A[i], 2);
    }
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A.length - 1 - i; j++) {
        if (A[j] > A[j + 1]) {
          int temp = A[j];
          A[j] = A[j + 1];
          A[j + 1] = temp;
        }
      }
    }
    return A;
  }
}
