package com.zj.leetcode.array;

/**
 * Created on 2020/12/1.
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/javaer-fen-fa-gai-zao-3chong-fang-shi-du-ji-bai-li/
 */
public class SearchRange {
  int[] result = {-1, -1};

  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return result;
    }
    searchArea(nums, target, 0, nums.length - 1);
    return result;
  }

  private void searchArea(int[] nums, int target, int startIndex, int endIndex) {
    if (startIndex > endIndex) {
      return;
    }
    int curIndex = (startIndex + endIndex) / 2;
    if (nums[curIndex] > target) {
      searchArea(nums, target, startIndex, curIndex - 1);
    } else if (nums[curIndex] < target) {
      searchArea(nums, target, curIndex + 1, endIndex);
    } else {
      int s = curIndex - 1, e = curIndex + 1;
      while (s >= startIndex && nums[s] == target) {
        s--;
      }
      result[0] = s + 1;
      while (e <= endIndex && nums[e] == target) {
        e++;
      }
      result[1] = e - 1;
    }
  }

  //二分法查找
  public int searchRangeHelper(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] < target) {
        low = mid + 1;
      } else if (nums[mid] > target) {
        high = mid - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
