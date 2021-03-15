package com.zj.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3/15/21.
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *  
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 */

public class SpiralOrder {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int x = 0, y = 0;
    int row = matrix.length;
    int colon = matrix[0].length;
    int times = Math.min(row % 2 == 0 ? row / 2 : row / 2 + 1,
        colon % 2 == 0 ? colon / 2 : colon / 2 + 1);
    for (int i = 0; i < times; i++) {
      while (y < colon - i) {
        result.add(matrix[x][y++]);
        if (y == colon - i) {
          y--;
          x++;
          break;
        }
      }
      while (x < row - i) {
        result.add(matrix[x++][y]);
        if (x == row - i) {
          x--;
          y--;
          break;
        }
      }
      if (i == times - 1 && Math.min(row, colon) % 2 == 1) {
        break;
      }
      while (y >= i) {
        result.add(matrix[x][y--]);
        if (y < i) {
          y++;
          x--;
          break;
        }
      }
      while (x > i) {
        result.add(matrix[x--][y]);
        if (x == i) {
          x++;
          y++;
          break;
        }
      }
    }
    return result;
  }
}
