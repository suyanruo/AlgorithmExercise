package com.zj.leetcode.array;

/**
 * Created on 3/1/21.
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *  
 *
 * 示例：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 *
 * 参考：https://leetcode-cn.com/problems/range-sum-query-immutable/solution/jian-dan-wen-ti-xi-zhi-fen-xi-qian-tan-q-t2nz/
 */

public class NumArray {
  /**
   * 暴力法
   */
  public class Solution {
    private int[] numArray;

    public Solution(int[] nums) {
      this.numArray = nums;
    }

    public int sumRange(int i, int j) {
      if (i < 0) {
        i = 0;
      }
      if (j >= numArray.length) {
        j = numArray.length - 1;
      }
      int sum = 0;
      for (int k = i; k <= j; k++) {
        sum += numArray[k];
      }
      return sum;
    }
  }

  /**
   * 计算所有前缀和并保存到一个数组array中，之后求i到j的和时只需要计算array[j] - array[i - 1]即可
   */
  public class SolutionPre {
    private int[] preArray;

    public SolutionPre(int[] nums) {
      preArray = new int[nums.length + 1];
      preArray[0] = 0;
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        preArray[i + 1] = sum;
      }
    }

    public int sumRange(int i, int j) {
      return preArray[j + 1] - preArray[i];
    }
  }
}
