package com.zj.leetcode.sort;

/**
 * Created on 4/12/21.
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 *
 * 链接：https://leetcode-cn.com/problems/largest-number
 *
 * ref: https://leetcode-cn.com/problems/largest-number/solution/fu-xue-ming-zhu-zhuan-cheng-zi-fu-chuan-mm2s6/
 */

public class LargestNumber {
  public String largestNumber(int[] nums) {
    String[] numString = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      numString[i] = String.valueOf(nums[i]);
    }
    shellSort(numString);
    StringBuilder result = new StringBuilder();
    for (String s : numString) {
      result.append(s);
    }
    if (result.toString().charAt(0) == '0') {
      return "0";
    }
    return result.toString();
  }

  private void shellSort(String[] nums) {
    int len = nums.length;
    int gap = len / 2;
    String current;
    int preIndex;
    while (gap > 0) {
      for (int i = gap; i < len; i++) {
        current = nums[i];
        preIndex = i - gap;
        while (preIndex >= 0 && compareString(current, nums[preIndex]) > 0) {
          nums[preIndex + gap] = nums[preIndex];
          preIndex -= gap;
        }
        nums[preIndex + gap] = current;
      }
      gap /= 2;
    }
  }

  private int compareString(String s1, String s2) {
    return (s1 + s2).compareTo(s2 + s1);
  }
}
