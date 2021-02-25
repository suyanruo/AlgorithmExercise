package com.zj.leetcode.dynamic;

import java.util.List;

/**
 * Created on 2/25/21.
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 * 链接：https://leetcode-cn.com/problems/triangle
 *
 * 参考：https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
 */

public class MinimumTotal {

  public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
      return findMin(triangle, 1, 0);
    }

    private int findMin(List<List<Integer>> triangle, int topLevel, int index) {
      int totalLevel = triangle.size();
      int currentNum = triangle.get(topLevel - 1).get(index);
      if (topLevel ==  totalLevel) {
        return currentNum;
      }
      return currentNum + Math.min(findMin(triangle, topLevel + 1, index),
          findMin(triangle, topLevel + 1, index + 1));
    }
  }


  public class Solution2 {
    Integer[][] cache;

    public int minimumTotal(List<List<Integer>> triangle) {
      cache = new Integer[triangle.size()][triangle.size()];
      return findMin(triangle, 0, 0);
    }

    private int findMin(List<List<Integer>> triangle, int rowIndex, int colIndex) {
      if (rowIndex == triangle.size()) {
        return 0;
      }
      int currentNum = triangle.get(rowIndex).get(colIndex);
      if (cache[rowIndex][colIndex] != null) {
        return cache[rowIndex][colIndex];
      }
      return cache[rowIndex][colIndex] = currentNum + Math.min(findMin(triangle, rowIndex + 1, colIndex),
          findMin(triangle, rowIndex + 1, colIndex + 1));
    }
  }
}
