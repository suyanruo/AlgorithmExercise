package com.zj.leetcode.array;

/**
 * Created on 3/27/21.
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3：
 *
 * 输入：nums = [1,1]
 * 输出：1
 * 示例 4：
 *
 * 输入：nums = [1,1,2]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 2 <= n <= 3 * 104
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 *
 * 参考：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
 */

class FindDuplicate {

  public class Solution {
    public int findDuplicate(int[] nums) {
      int fast = nums[nums[0]], slow = nums[0];
      while (fast != slow) {
        fast = nums[nums[fast]];
        slow = nums[slow];
      }
      fast = 0;
      while (fast != slow) {
        fast = nums[fast];
        slow = nums[slow];
      }
      return slow;
    }
  }

  public class Solution2 {
    public int findDuplicate(int[] nums) {
      int start = 1, end = nums.length - 1;
      int pivot = (start + end + 1) / 2;
      int count = 0;
      while (start < end) {
        for (int num : nums) {
          if (num <= pivot) {
            count++;
          }
        }
        if (count > pivot) {
          end = pivot;
        } else {
          start = pivot + 1;
        }
      }
      return start;
    }
  }
}
