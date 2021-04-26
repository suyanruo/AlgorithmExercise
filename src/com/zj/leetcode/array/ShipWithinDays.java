package com.zj.leetcode.array;

/**
 * Created on 4/26/21.
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 *
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 *
 * ref: https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/solution/gong-shui-san-xie-li-yong-er-duan-xing-z-95zj/
 */

public class ShipWithinDays {
  public int shipWithinDays(int[] weights, int D) {
    int min = 0, max = 0, sum = 0;
    for (int w : weights) {
      min = Math.max(min, w);
      sum += w;
    }
    min = Math.max(min, sum / D);
    max = sum;
    while (min < max) {
      int mid = (min + max) >>> 2;
      if (canShip(weights, D, mid)) {
        max = mid;
      } else {
        min = mid + 1;
      }
    }
    return min;
  }

  private boolean canShip(int[] weights, int D, int weight) {
    int daySum = 0, days = 1;
    for (int i = 0; i < weights.length; i++) {
      if (daySum + weights[i] > weight) {
        days++;
        if (days > D) {
          return false;
        }
        daySum = weights[i];
      } else {
        daySum += weights[i];
      }
    }
    return true;
  }
}
