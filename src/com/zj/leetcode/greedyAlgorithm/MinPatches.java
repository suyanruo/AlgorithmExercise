package com.zj.leetcode.greedyAlgorithm;

/**
 * Created on 12/29/20.
 *
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 *
 * 示例 1:
 *
 * 输入: nums = [1,3], n = 6
 * 输出: 1
 * 解释:
 * 根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
 * 现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
 * 其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
 * 所以我们最少需要添加一个数字。
 *
 * 链接：https://leetcode-cn.com/problems/patching-array
 *
 * 解答：https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-tan-xin-suan-fa-b4bwr/
 */

public class MinPatches {
  public int minPatches(int[] nums, int n) {
    //需要补充的数字个数
    int count = 0;
    //累加的总和
    long total = 0;
    //访问的数组下标索引
    int index = 0;
    while (total < n) {
      if (index < nums.length && total >= nums[index] - 1) {
        //如果数组能组成的数字范围是[1,total]，那么加上nums[index]
        //就变成了[1,total]U[nums[index],total+nums[index]]
        //结果就是[1,total+nums[index]]
        total += nums[index++];
      } else {
        //添加一个新数字，并且count加1
        count++;
        total += (total + 1);
      }
    }
    return count;
  }
}
