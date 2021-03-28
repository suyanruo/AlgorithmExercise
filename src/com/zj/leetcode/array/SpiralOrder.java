package com.zj.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 3/15/21.
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *  
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 */

public class SpiralOrder {
    public class Solution {
        List<Integer> result = new ArrayList<>();

        public List<Integer> spiralOrder(int[][] matrix) {
            traverse(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
            return result;
        }

        private void traverse(int[][] matrix, int startX, int startY, int endX, int endY) {
            if (startX > endX || startY > endY) {
                return;
            }
            if (startX == endX) {
                for (int i = startY; i <= endY; i++) {
                    result.add(matrix[startX][i]);
                }
                return;
            }
            if (startY == endY) {
                for (int i = startX; i <= endX; i++) {
                    result.add(matrix[i][endY]);
                }
                return;
            }
            for (int i = startY; i < endY; i++) {
                result.add(matrix[startX][i]);
            }
            for (int i = startX; i < endX; i++) {
                System.out.println("x:" + i + ", y:" + endY);
                result.add(matrix[i][endY]);
            }
            for (int i = endY; i > startY; i--) {
                result.add(matrix[endX][i]);
            }
            for (int i = endX; i > startX; i--) {
                result.add(matrix[i][startY]);
            }
            traverse(matrix, startX + 1, startY + 1, endX - 1, endY - 1);
        }
    }

    public class Solution2 {
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

}
