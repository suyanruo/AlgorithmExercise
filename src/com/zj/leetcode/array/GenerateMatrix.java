package com.zj.leetcode.array;

/**
 * Created on 3/16/21.
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 */

public class GenerateMatrix {
  public int[][] generateMatrix(int n) {
    int[][] result = new int[n][n];
    circle(1, 0, n - 1, result);
    return result;
  }

  private void circle(int num, int start, int end, int[][] arr) {
    if (start > end) {
      return;
    }
    if (start == end) {
      arr[start][start] = num;
      return;
    }
    for (int i = start; i < end; i++) {
      arr[start][i] = num++;
    }
    for (int i = start; i < end; i++) {
      arr[i][end] = num++;
    }
    for (int i = end; i > start; i--) {
      arr[end][i] = num++;
    }
    for (int i = end; i > start; i--) {
      arr[i][start] = num++;
    }
    circle(num, start + 1, end - 1, arr);
  }
}
