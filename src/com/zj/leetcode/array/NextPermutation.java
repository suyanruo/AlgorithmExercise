package com.zj.leetcode.array;

/**
 * Created on 2020/11/10.
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 链接：https://leetcode-cn.com/problems/next-permutation
 */
public class NextPermutation {
  public void nextPermutation(int[] nums) {
    int frontIndex = -1, lastIndex = -1;
    for (int i = nums.length - 1; i > 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums[j] < nums[i] && frontIndex < j) {
          frontIndex = j;
          lastIndex = i;
          break;
        }
      }
    }
    if (frontIndex >= 0) {
      int temp = nums[frontIndex];
      nums[frontIndex] = nums[lastIndex];
      nums[lastIndex] = temp;
      smallestArray(nums, frontIndex + 1, nums.length - 1);
      return;
    }
    reverseArray(nums);
  }

  private void reverseArray(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < nums.length / 2; i++) {
      int temp = nums[i];
      nums[i] = nums[len - 1 - i];
      nums[len - 1 - i] = temp;
    }
  }

  private void smallestArray(int[] nums, int startIndex, int endIndex) {
    for (int i = endIndex; i > startIndex; i--) {
      for (int j = startIndex; j < i; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }
  }
}
