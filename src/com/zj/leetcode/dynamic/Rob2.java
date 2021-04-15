package com.zj.leetcode.dynamic;

/**
 * Created on 4/15/21.
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 *
 * 链接：https://leetcode-cn.com/problems/house-robber-ii
 *
 * ref: https://leetcode-cn.com/problems/house-robber-ii/solution/jian-yi-dong-tai-gui-hua-xie-fa-shi-jian-c6fv/
 */

public class Rob2 {
  public int rob(int[] nums) {
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    if (len == 1) {
      return nums[0];
    }
    if (len == 2) {
      return Math.max(nums[0], nums[1]);
    }
    if (len == 3) {
      return Math.max(Math.max(nums[0], nums[1]), nums[2]);
    }
    int ans1 = 0, ans2 = 0;
    int first1 = nums[0], first2 = Math.max(nums[0], nums[1]);
    for (int i = 2; i < len - 1; i++) {
      ans1 = Math.max(first1 + nums[i], first2);
      first1 = first2;
      first2 = ans1;
    }
    first1 = nums[1];
    first2 = Math.max(nums[1], nums[2]);
    for (int i = 3; i < len; i++) {
      ans2 = Math.max(first1 + nums[i], first2);
      first1 = first2;
      first2 = ans2;
    }
    return Math.max(ans1, ans2);
  }
}
