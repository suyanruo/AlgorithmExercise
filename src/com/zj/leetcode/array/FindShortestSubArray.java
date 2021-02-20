package com.zj.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created on 2/20/21.
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 *
 * 参考：https://leetcode-cn.com/problems/degree-of-an-array/solution/xiang-xi-fen-xi-ti-yi-yu-si-lu-jian-ji-d-nvdy/
 *      https://leetcode-cn.com/problems/degree-of-an-array/solution/yi-ci-shu-zu-bian-li-ha-xi-biao-by-dong-d9lvg/
 */

public class FindShortestSubArray {


  public static class Solution1 {
    public int findShortestSubArray(int[] nums) {
      int left = 0, right = 0;
      HashMap<Integer, Integer> map = new HashMap<>();
      int degree = getDegree(nums);
      int res = nums.length;
      while (right < nums.length) {
        map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
        right++;
        while (map.get(nums[right - 1]) == degree) {
          map.put(nums[left], map.get(nums[left]) - 1);
          res = Math.min(res, right - left);
          left++;
        }
      }
      return res;
    }

    private int getDegree(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int degree = 0;
      for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        degree = Math.max(degree, map.get(nums[i]));
      }
      return degree;
    }
  }

  public static class Solution2 {
    public int findShortestSubArray(int[] nums) {
      int maxNum = Arrays.stream(nums).max().getAsInt();
      int arrayLen = Math.max(nums.length, maxNum + 1);
      int[] left = new int[arrayLen];
      int[] right = new int[arrayLen];
      int[] counter = new int[arrayLen];
      Arrays.fill(left, -1);
      Arrays.fill(right, -1);
      Arrays.fill(counter, -1);

      int degree = 0;
      for (int i = 0; i < nums.length; i++) {
        if (left[nums[i]] == -1) {
          left[nums[i]] = i;
        }
        right[nums[i]] = i;
        counter[nums[i]]++;
        degree = Math.max(degree, counter[nums[i]]);
      }
      int res = nums.length + 1;
      for (int i = 0; i < nums.length; i++) {
        if (counter[nums[i]] == degree) {
          res = Math.min(res, right[nums[i]] - left[nums[i]] + 1);
        }
      }
      return res;
    }
  }
}
