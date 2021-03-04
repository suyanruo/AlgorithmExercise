package com.zj.leetcode.dynamic;

import java.util.Arrays;

/**
 * Created on 3/4/21.
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 *
 * 参考：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/zui-chang-shang-sheng-zi-xu-lie-bian-xin-6s8d/
 */

public class MaxEnvelopes {

  public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
      int len = envelopes.length;
      if (len == 0) {
        return len;
      }
      Arrays.sort(envelopes, (o1, o2) -> o1[0] - o2[0]);
      int[] preNMax = new int[len];
      int result = 0;
      for (int i = 0; i < len; i++) {
        preNMax[i] = 1;
        for (int j = 0; j < i; j++) {
          if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
            preNMax[i] = Math.max(preNMax[i], preNMax[j] + 1);
          }
        }
        result = Math.max(result, preNMax[i]);
      }
      return result;
    }
  }

}
