package com.zj.leetcode.array;

/**
 * Created on 2020/8/28.
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class ArraysMedian {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int count1 = 0, count2 = 0;
    double median = 0, currentNum = 0;

    for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
      if (nums1.length == count1) {
        currentNum = nums2[count2++];
      } else if (nums2.length == count2) {
        currentNum = nums1[count1++];
      } else if (nums1[count1] <= nums2[count2]) {
        currentNum = nums1[count1++];
      } else {
        currentNum = nums2[count2++];
      }
      if (i == (nums1.length + nums2.length) / 2 - 1 && (nums1.length + nums2.length) % 2 == 0) {
        median = currentNum;
      }
      if (i == (nums1.length + nums2.length) / 2) {
        if (median != 0) {
          median = (median + currentNum) / 2;
        } else {
          median = currentNum;
        }
      }
    }
    return median;
  }
}
