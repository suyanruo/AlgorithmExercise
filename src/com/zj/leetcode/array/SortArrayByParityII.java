package com.zj.leetcode.array;

/**
 * Created on 2020/11/12.
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 */
public class SortArrayByParityII {
  public int[] sortArrayByParityII(int[] A) {
    int oddIndex = 0, evenIndex = 0;
    while (true) {
      for (; evenIndex < A.length; evenIndex++) {
        if (A[evenIndex] % 2 == 0 && evenIndex % 2 != 0) {
          break;
        }
      }
      for (; oddIndex < A.length; oddIndex++) {
        if (A[oddIndex] % 2 != 0 && oddIndex % 2 == 0) {
          break;
        }
      }
      if (evenIndex >= A.length || oddIndex >= A.length) {
        break;
      }
      int temp = A[evenIndex];
      A[evenIndex] = A[oddIndex];
      A[oddIndex] = temp;
    }
    return A;
  }
}
