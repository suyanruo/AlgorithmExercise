package com.zj.leetcode.dynamic;

/**
 * Created on 4/16/21.
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 * 链接：https://leetcode-cn.com/problems/scramble-string
 *
 * ref: https://leetcode-cn.com/problems/scramble-string/solution/miao-dong-de-qu-jian-xing-dpsi-lu-by-sha-yu-la-jia/
 */

public class Scramble {
  public boolean isScramble(String s1, String s2) {
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    int n = s1.length();
    int m = s2.length();
    if (m != n) {
      return false;
    }
    boolean[][][] dp = new boolean[n][n][n + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j][1] = c1[i] == c2[j];
      }
    }
    for (int len = 2; len <= n; len++) {
      for (int i = 0; i <= n - len; i++) {
        for (int j = 0; j <= n - len; j++) {
          for (int k = 1; k < len; k++) {
            if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
              dp[i][j][len] = true;
              break;
            }
            if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
              dp[i][j][len] = true;
              break;
            }
          }
        }
      }
    }
    return dp[0][0][n];
  }
}
