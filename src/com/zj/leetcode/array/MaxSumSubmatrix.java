package com.zj.leetcode.array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created on 4/22/21.
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 示例 2：
 *
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 *
 * 关联题目：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 *
 * 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
 *
 * ref: https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/gong-shui-san-xie-you-hua-mei-ju-de-ji-b-dh8s/
 */

public class MaxSumSubmatrix {
  public class Solution {
    public int maxSumSubmatrix(int[][] mat, int k) {
      int m = mat.length, n = mat[0].length;
      int[][] sum = new int[m + 1][n + 1];

      // 1.计算二维数组前缀和
      for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
          sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
        }
      }

      // 2.遍历特定上下边界和右边界的二维数组，通过二分查找找到最合适的左边界
      int ans = Integer.MIN_VALUE;
      for (int top = 1; top <= m; top++) {
        for (int bot = top; bot <= m; bot++) {
          TreeSet<Integer> ts = new TreeSet<>();
          ts.add(0);
          for (int r = 1; r <= n; r++) {
            int right = sum[bot][r] - sum[top - 1][r];
            Integer left = ts.ceiling(right - k);
            if (left != null) {
              ans = Math.max(ans, right - left);
            }
            ts.add(right);
          }
        }
      }
      return ans;
    }
  }

  public class Solution2 {
    public int maxSumSubmatrix(int[][] mat, int k) {
      int m = mat.length, n = mat[0].length;
      boolean isRight = n > m;
      int[] sum = new int[isRight ? n + 1 : m + 1];
      int ans = Integer.MIN_VALUE;
      for (int i = 1; i <= (isRight ? m : n); i++) {
        Arrays.fill(sum, 0);
        for (int j = i; j <= (isRight ? m : n); j++) {
          TreeSet<Integer> ts = new TreeSet<>();
          ts.add(0);
          int a = 0;
          for (int fix = 1; fix <= (isRight ? n : m); fix++) {
            sum[fix] += isRight ? mat[j - 1][fix - 1] : mat[fix - 1][j - 1];
            a += sum[fix];
            Integer b = ts.ceiling(a - k);
            if (b != null) {
              ans = Math.max(ans, a - b);
            }
            ts.add(a);
          }
        }
      }
      return ans;
    }
  }
}
