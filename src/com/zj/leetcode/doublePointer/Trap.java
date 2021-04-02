package com.zj.leetcode.doublePointer;

/**
 * Created on 4/2/21.
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 链接：https://leetcode-cn.com/problems/volume-of-histogram-lcci
 *
 * ref: https://leetcode-cn.com/problems/volume-of-histogram-lcci/solution/fu-xue-ming-zhu-mian-xiang-lie-de-ji-sua-6uqr/
 */

public class Trap {
  public int trap(int[] height) {
    if (height.length <= 2) {
      return 0;
    }
    int left = 0, right = height.length - 1;
    int lHeight = 0, rHeight = 0;
    int result = 0;
    while (left <= right) {
      if (height[left] < height[right]) {
        if (height[left] < lHeight) {
          result += lHeight - height[left];
        } else {
          lHeight = height[left];
        }
        left++;
      } else {
        if (height[right] < rHeight) {
          result += rHeight - height[right];
        } else {
          rHeight = height[right];
        }
        right--;
      }
    }
    return result;
  }
}
