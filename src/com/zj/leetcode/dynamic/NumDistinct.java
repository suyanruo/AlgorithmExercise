package com.zj.leetcode.dynamic;

/**
 * Created on 3/17/21.
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *  
 * 示例 1：
 *
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 *
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences/solution/xiang-jie-zi-fu-chuan-pi-pei-wen-ti-de-t-wdtk/
 */

public class NumDistinct {
  public int numDistinct(String s, String t) {
    int sl = s.length();
    int tl = t.length();
    char[] sChars = (" " + s).toCharArray();
    char[] tChars = (" " + t).toCharArray();
    int[][] childCount = new int[sl + 1][tl + 1];
    for (int i = 0; i <= sl; i++) {
      childCount[i][0] = 1;
    }
    for (int i = 1; i <= sl; i++) {
      for (int j = 1; j <= tl; j++) {
        childCount[i][j] = childCount[i - 1][j];
        if (sChars[i] == tChars[j]) {
          childCount[i][j] += childCount[i - 1][j - 1];
        }
      }
    }
    return childCount[sl][tl];
  }
}
