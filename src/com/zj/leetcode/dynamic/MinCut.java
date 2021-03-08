package com.zj.leetcode.dynamic;

/**
 * Created on 3/8/21.
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 *
 * 返回符合要求的 最少分割次数 。
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 *
 * 输入：s = "ab"
 * 输出：1
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 *
 * 参考：https://leetcode-cn.com/problems/palindrome-partitioning-ii/solution/xiang-jie-liang-bian-dong-tai-gui-hua-ji-s5xr/
 */

public class MinCut {
  public int minCut(String s) {
    boolean[][] palindromeLog = new boolean[s.length()][s.length()];
    char[] cs = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j >= 0; j--) {
        if (i == j) {
          palindromeLog[j][i] = true;
        } else {
          if (i - j + 1 == 2) {
            palindromeLog[j][i] = (cs[i] == cs[j]);
          } else {
            palindromeLog[j][i] = (cs[i] == cs[j] && palindromeLog[j + 1][i - 1]);
          }
        }
      }
    }
    int[] minArr = new int[s.length()];
    int tempCount;
    for (int i = 0; i < s.length(); i++) {
      minArr[i] = 0;
      tempCount = s.length();
      if (!palindromeLog[0][i]) {
        for (int j = i; j >= 0; j--) {
          if (palindromeLog[j][i]) {
            tempCount = Math.min(tempCount, minArr[j - 1] + 1);
          }
        }
        minArr[i] = tempCount;
      }
    }
    return minArr[s.length() - 1];
  }
}
