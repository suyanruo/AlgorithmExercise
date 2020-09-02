package com.zj.sword2offer;

/**
 * Created on 2020/9/2.
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 *  
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 */
public class StringIsNumber {
  private int index = 0;

  public boolean isNumber(String s) {
    if (s.isEmpty()) {
      return false;
    }
    while (index < s.length() && s.charAt(index) == ' ') {
      index++;
    }
    if (index == s.length()) return false;
    boolean isInteger = isInteger(s);
    if (index == s.length()) return isInteger;
    if (s.charAt(index) == '.') {
      index++;
      if (index == s.length()) return isInteger;
      isInteger = isInteger || isUnsignedInteger(s);
    }
    if (index == s.length()) return isInteger;
    if (s.charAt(index) == 'e' || s.charAt(index) == 'E') {
      index++;
      if (index == s.length()) return false;
      isInteger = isInteger && isInteger(s);
    }
    if (index == s.length()) return isInteger;
    while (index < s.length() && s.charAt(index) == ' ') {
      index++;
    }
    return index == s.length() && isInteger;
  }

  private boolean isInteger(String s) {
    if (s.charAt(index) == '+' || s.charAt(index) == '-') {
      index++;
    }
    return isUnsignedInteger(s);
  }

  private boolean isUnsignedInteger(String s) {
    int before = index;
    while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
      index++;
    }
    return index > before;
  }
}
