package com.zj.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020/8/26.
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class PhoneNumberMonogram {
  private static String[] ALPHABETS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  private List<String> result = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.length() == 0) {
      return result;
    }
    generateMonogram(digits, new StringBuilder(), 0);
    return result;
  }

  private void generateMonogram(String digits, StringBuilder curMonogram, int index) {
    if (index == digits.length()) {
      result.add(curMonogram.toString());
      return;
    }
    int curNumber = digits.charAt(index) - '0';
    String curAlphabets = ALPHABETS[curNumber];
    for (int i = 0; i < curAlphabets.length(); i++) {
      curMonogram.append(curAlphabets.charAt(i));
      generateMonogram(digits, curMonogram, index + 1);
      curMonogram.deleteCharAt(curMonogram.length() - 1);
    }
  }
}
