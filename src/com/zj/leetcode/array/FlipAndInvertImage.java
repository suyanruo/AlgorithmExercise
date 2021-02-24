package com.zj.leetcode.array;

/**
 * Created on 2/24/21.
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 */

public class FlipAndInvertImage {
  public int[][] flipAndInvertImage(int[][] A) {
    int temp;
    int colLength = A[0].length;
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length / 2; j++) {
        temp = 1 - A[i][j];
        A[i][j] = 1 - A[i][colLength - 1 - j];
        A[i][colLength - 1 - j] = temp;
      }
      if (colLength % 2 == 1) {
        A[i][colLength / 2] = 1 - A[i][colLength / 2];
      }
    }
    return A;
  }
}
