package com.zj.leetcode.array;

/**
 * Created on 3/30/21.
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 *
 * 参考：https://leetcode-cn.com/problems/search-a-2d-matrix/solution/gong-shui-san-xie-yi-ti-shuang-jie-er-fe-l0pq/
 */

public class SearchMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rowLen = matrix.length;
    int colonLen = matrix[0].length;
    int start = 0, end = rowLen - 1;
    int mid = 0;
    int row, colon;
    while (start < end) {
      mid = (start + end + 1) / 2;
      if (matrix[mid][0] > target) {
        end = mid - 1;
      } else if (matrix[mid][0] < target) {
        start = mid;
      } else {
        return true;
      }
    }
    if (matrix[end][0] > target) {
      System.out.println("row = " + mid);
      return false;
    }
    row = end;
    start = 0;
    end = colonLen - 1;
    while (start < end) {
      mid = (start + end + 1) / 2;
      if (matrix[row][mid] > target) {
        end = mid - 1;
      } else if (matrix[row][mid] < target) {
        start = mid;
      } else {
        return true;
      }
    }
    colon = end;
    System.out.println("r: " + row + "  c: " + colon);
    return matrix[row][colon] == target;
  }
}
