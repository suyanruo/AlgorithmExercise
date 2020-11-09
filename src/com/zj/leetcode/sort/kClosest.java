package com.zj.leetcode.sort;

import java.util.Arrays;

/**
 * Created on 2020/11/9.
 *
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 *
 * 解答：https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/kuai-lai-miao-dong-topkkuai-pai-bian-xing-da-gen-d/
 */
public class kClosest {
  public int[][] kClosest(int[][] points, int K) {
    return quickSort(points, 0, points.length - 1, K - 1);
  }

  private int[][] quickSort(int[][] points, int lo, int hi, int idx) {
    if (lo > hi) {
      return new int[0][0];
    }
    int curIdx = partition(points, lo, hi);
    if (curIdx == idx) {
      return Arrays.copyOf(points, idx + 1);
    }
    return curIdx > idx ? quickSort(points, lo, curIdx - 1, idx) : quickSort(points, curIdx + 1, hi, idx);
  }

  private int partition(int[][] points, int lo, int hi) {
    int[] value = points[lo];
    int length = value[0] * value[0] + value[1] * value[1];
    int s = lo, e = hi + 1;
    while (true) {
      while (++s < hi && points[s][0] * points[s][0] + points[s][1] * points[s][1] < length);
      while (--e > lo && points[e][0] * points[e][0] + points[e][1] * points[e][1] > length);
      if (s >= e) {
        break;
      }
      int[] temp = points[s];
      points[s] = points[e];
      points[e] = temp;
    }
    points[lo] = points[e];
    points[e] = value;
    return e;
  }
}
