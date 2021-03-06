package com.zj.leetcode.string;

/**
 * Created on 2020/8/24.
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 *
 * 输入: "abab"
 *
 * 输出: True
 *
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 */
public class RepeatedString {

  public boolean repeatedSubstringPattern(String s) {
    if (s == null || s.length() == 0) return false;
    int len = s.length();
    for (int i = 1; i <= len / 2; i++) {
      if (len % i == 0) {
        boolean match = true;
        for (int j = i; j < len; j++) {
          if (s.charAt(j) != s.charAt(j - i)) {
            match = false;
            break;
          }
        }
        if (match) {
          return true;
        }
      }
    }
    return false;
  }
}
