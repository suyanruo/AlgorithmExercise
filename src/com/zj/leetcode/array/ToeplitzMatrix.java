package com.zj.leetcode.array;

/**
 * Created on 2/22/21.
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 */

public class ToeplitzMatrix {
  public boolean isToeplitzMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = 0; j < matrix[0].length - 1; j++) {
        if (matrix[i][j] != matrix[i + 1][j + 1]) {
          return false;
        }
      }
    }
    return true;
  }
}
