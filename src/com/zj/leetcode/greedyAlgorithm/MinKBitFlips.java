package com.zj.leetcode.greedyAlgorithm;

import java.util.LinkedList;

/**
 * Created on 2/18/21.
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 *
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 * 示例 2：
 *
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 * 示例 3：
 *
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 *
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 *
 * 参考：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/solution/hua-dong-chuang-kou-shi-ben-ti-zui-rong-z403l/
 */

public class MinKBitFlips {
  private LinkedList<Integer> screenList = new LinkedList();

  public int minKBitFlips(int[] A, int K) {
    int length = A.length;
    int times = 0;
    for (int i = 0; i < length; i++) {
      if (screenList.size() > 0 && i > screenList.getFirst() + K - 1) {
        screenList.poll();
      }
      if (screenList.size() % 2 == A[i]) {
        if (i + K > length) {
          return -1;
        }
        screenList.offer(i);
        times++;
      }
    }
    return times;
  }
}
