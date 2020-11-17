package com.zj.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2020/11/17.
 *
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order
 *
 * 解答：https://leetcode-cn.com/problems/matrix-cells-in-distance-order/solution/si-chong-jie-fa-shu-zu-pai-xu-tong-pai-xu-bfs-mo-n/
 */
public class AllCellsDistOrder {

  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    int[][] result = new int[R * C][2];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        int dis = C * i + j;
        result[dis][0] = i;
        result[dis][1] = j;
      }
    }
    Arrays.sort(result, (o1, o2) -> {
      int dist1 = distance(o1[0], o1[1], r0, c0);
      int dist2 = distance(o2[0], o2[1], r0, c0);
      return Integer.compare(dist1, dist2);
    });
    return result;
  }

  private int distance(int rn, int cn, int r0, int c0) {
    return Math.abs(r0 - rn) + Math.abs(c0 - cn);
  }

  public int[][] allCellsDistOrderMyself(int R, int C, int r0, int c0) {
    List<int[]> result = new ArrayList<>();
    int sum = 1;
    boolean isFinished = false;
    result.add(new int[] {r0, c0});
    for (int row = 0; row < R; row++) {
      if (isFinished) {
        break;
      }
      for (int col = 0; col < C; col++) {
        if (row + col != sum) {
          break;
        }
        // 四个方向都超出匹配边界，退出查找
        if (r0 - row < 0 && r0 + row >= R && c0 - col < 0 && c0 + col >= C) {
          isFinished = true;
          break;
        }
        // 上
        if (r0 - row >= 0) {
          // 左
          if (c0 - col >= 0) {
            result.add(new int[] {r0 - row, c0 - col});
          }
          // 右
          if (c0 + col < C) {
            result.add(new int[] {r0 - row, c0 + col});
          }
        }
        // 下
        if (r0 + row < R) {
          // 左
          if (c0 - col >= 0) {
            result.add(new int[] {r0 + row, c0 - col});
          }
          // 右
          if (c0 + col < C) {
            result.add(new int[] {r0 + row, c0 + col});
          }
        }
        sum++;
      }
    }
    return result.toArray(new int[R][C]);
  }
}
