package com.zj.leetcode.doublePointer;

/**
 * Created on 4/20/21.
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 *
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 *
 * 学习：https://leetcode-cn.com/problems/implement-strstr/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/
 */

class StrStrImp {
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    if (haystack.length() == 0) {
      return -1;
    }
    if (haystack.length() < needle.length()) {
      return -1;
    }
    char[] hc = haystack.toCharArray();
    char[] nc = needle.toCharArray();
    int hLen = haystack.length();
    int nLen = needle.length();
    int hs = 0;
    while (hs <= hLen - nLen) {
      int i = 0;
      while (hc[hs + i] == nc[i]) {
        if (i == nLen - 1) {
          return hs;
        } else if (hs + i == hLen - 1) {
          return -1;
        }
        i++;
      }
      hs++;
    }
    return -1;
  }
}
