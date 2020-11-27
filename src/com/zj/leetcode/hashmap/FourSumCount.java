package com.zj.leetcode.hashmap;

import java.util.HashMap;

/**
 * Created on 2020/11/27.
 *
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 *
 * 解答：https://leetcode-cn.com/problems/4sum-ii/solution/chao-ji-rong-yi-li-jie-de-fang-fa-si-shu-xiang-jia/
 */
public class FourSumCount {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    HashMap<Integer, Integer> sumMap = new HashMap<>();
    int result = 0;
    int tempSum;
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < B.length; j++) {
        tempSum = A[i] + B[j];
        sumMap.put(tempSum, sumMap.getOrDefault(tempSum, 0) + 1);
      }
    }

    for (int k = 0; k < C.length; k++) {
      for (int l = 0; l < D.length; l++) {
        tempSum = - (C[k] + D[l]);
        if (sumMap.containsKey(tempSum)) {
          result += sumMap.get(tempSum);
        }
      }
    }
    return result;
  }
}
