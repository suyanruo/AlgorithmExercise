package com.zj.leetcode.array;

/**
 * Created on 2020/11/19.
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int firstZeroIndex = -1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        if (firstZeroIndex < 0) {
          firstZeroIndex = i;
        }
      } else {
        if (firstZeroIndex >= 0) {
          swapNums(nums, firstZeroIndex, i);
          firstZeroIndex++;
        }
      }
    }
  }

  private void swapNums(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
  }
}
