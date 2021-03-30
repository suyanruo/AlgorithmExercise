package com.zj.leetcode.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2/26/21.
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 链接：https://leetcode-cn.com/problems/subsets
 *
 * 参考：https://leetcode-cn.com/problems/subsets/solution/hui-su-suan-fa-by-powcai-5/
 */

class Subsets {

  public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      result.add(new ArrayList<>());
      for (int num : nums) {
        int size = result.size();
        for (int i = 0; i < size; i++) {
          List<Integer> temp = new ArrayList<>(result.get(i));
          temp.add(num);
          result.add(temp);
        }
      }
      return result;
    }
  }

  public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      backTrack(nums, 0, result, new ArrayList<>());
      return result;
    }

    private void backTrack(int[] nums, int startIndex, List<List<Integer>> res, List<Integer> temp) {
      res.add(new ArrayList<>(temp));
      for (int i = startIndex; i < nums.length; i++) {
        temp.add(nums[i]);
        backTrack(nums, startIndex + 1, res, temp);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
