package com.zj.leetcode.sort;

/**
 * Created on 2020/11/26.
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-gap
 */
public class MaximumGap {
  public int maximumGap(int[] nums) {
    if (nums.length <= 1) {
      return 0;
    }
    shellSort(nums);
    int maxGap = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
    }
    return maxGap;
  }

  private void shellSort(int[] nums) {
    int length = nums.length;
    int gap = length / 2;
    int preIndex, currentNum;
    while (gap > 0) {
      for (int i = gap; i < length; i++) {
        currentNum = nums[i];
        preIndex = i - gap;
        while (preIndex >= 0 && currentNum < nums[preIndex]) {
          nums[preIndex + gap] = nums[preIndex];
          preIndex -= gap;
        }
        nums[preIndex + gap] = currentNum;
      }
      gap /= 2;
    }
  }
}
