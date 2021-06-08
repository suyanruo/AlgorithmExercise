package com.zj.leetcode.dynamic;

/**
 * Created by ZhangJian on 2021/6/8.
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * 链接：https://leetcode-cn.com/problems/target-sum
 * ref: https://leetcode-cn.com/problems/target-sum/solution/gong-shui-san-xie-yi-ti-si-jie-dfs-ji-yi-et5b/
 */
public class FindTargetSumWays {
    public class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (target > sum) {
                return 0;
            }
            int[][] f = new int[n + 1][2 * sum + 1];
            f[0][sum] = 1;
            for (int i = 1; i <= n; i++) {
                int x = nums[i - 1];
                for (int j = -sum; j <= sum; j++) {
                    if (j - x + sum >= 0) {
                        f[i][j + sum] += f[i - 1][j - x + sum];
                    }
                    if (j + x + sum <= 2 * sum) {
                        System.out.println("j = " + j + ", x = " + x + ", sum = " + sum + ", " + (j + x + sum));
                        f[i][j + sum] += f[i - 1][j + x + sum];
                    }
                }
            }
            return f[n][target + sum];
        }
    }

    public class Solution2 {
        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (target > sum || (sum - target) % 2 != 0) {
                return 0;
            }
            int t = (sum - target) / 2;
            int[][] f = new int[n + 1][t + 1];
            f[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                int x = nums[i - 1];
                for (int j = 0; j <= t; j++) {
                    f[i][j] = f[i - 1][j];
                    if (j >= x) {
                        f[i][j] += f[i - 1][j - x];
                    }
                }
            }
            return f[n][t];
        }
    }
}
