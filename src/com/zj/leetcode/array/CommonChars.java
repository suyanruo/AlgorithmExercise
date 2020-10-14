package com.zj.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/10/14.
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 */
public class CommonChars {

  public List<String> commonChars(String[] A) {
    List<String> result = new ArrayList<>();

    // 先得到第一个字符串里面每个字符的情况
    int[] charsNum = new int[26];
    for (int i = 0; i < A[0].length(); i++) {
      charsNum[A[0].charAt(i) - 'a']++;
    }

    // 从第1个开始逐个进行比较
    for (int i = 1; i < A.length; i++) {
      int[] curNum = new int[26];
      // 遍历第i个字符串
      for (char c : A[i].toCharArray()) {
        curNum[c - 'a']++;
      }

      // 将此时关于第i个字符串的情况与charCount对比，取小的即可
      for (int j = 0; j < charsNum.length; j++) {
        charsNum[j] = Math.min(charsNum[j], curNum[j]);
      }
    }

    // 此时的charCount即为所有的字符串出现的共有的最小元素的个数
    for (int i = 0; i < charsNum.length; i++) {
      while (charsNum[i] != 0) {
        result.add(String.valueOf((char) ('a' + i)));
        charsNum[i]--;
      }
    }

    return result;
  }
}
