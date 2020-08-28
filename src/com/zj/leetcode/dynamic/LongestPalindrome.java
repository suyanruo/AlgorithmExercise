package com.zj.leetcode.dynamic;

/**
 * Created on 2020/8/28.
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 */
public class LongestPalindrome {

  public String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }
    char[] chars = s.toCharArray();
    int length = s.length();
    boolean[][] palindromeList = new boolean[length][length];

    for (int i = 0; i <length; i++) {
      palindromeList[i][i] = true;
    }

    int maxLength = 1, firstIndex = 0;
    for (int j = 1; j < length; j++) {
      for (int i = 0; i < j; i++) {
        if (chars[i] == chars[j]) {
          if (j - i < 3) {
            palindromeList[i][j] = true;
          } else {
            palindromeList[i][j] = palindromeList[i + 1][j - 1];
          }
        } else {
          palindromeList[i][j] = false;
        }

        if (palindromeList[i][j] && j - i + 1 > maxLength) {
          firstIndex = i;
          maxLength = j - i + 1;
        }
      }
    }

    return s.substring(firstIndex, maxLength + firstIndex);
  }
}
