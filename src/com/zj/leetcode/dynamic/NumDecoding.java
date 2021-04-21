package com.zj.leetcode.dynamic;

/**
 * Created on 4/21/21.
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 链接：https://leetcode-cn.com/problems/decode-ways
 *
 * ref: https://leetcode-cn.com/problems/decode-ways/solution/gong-shui-san-xie-gen-ju-shu-ju-fan-wei-ug3dd/
 */

public class NumDecoding {
  public int numDecoding(String s) {
    int l = s.length();
    if (l == 0) {
      return 0;
    }
    if (s.startsWith("0")) {
      return 0;
    }
    if (l == 1) {
      return 1;
    }
    char[] chars = s.toCharArray();
    int[] result = new int[l + 1];
    result[0] = 0;
    result[1] = 1;
    int r1, r2;
    for (int i = 2; i <= l; i++) {
      if (chars[i - 1] == '0') {
        if (chars[i - 2] > '2') {
          return 0;
        }
        r1 = 0;
      } else {
        r1 = result[i - 1];
      }
      int temp = (chars[i - 2] - '0') * 10 + chars[i - 1] - '0';
      if (temp > 26 || temp < 10) {
        r2 = 0;
      } else {
        r2 = result[i - 2];
      }
      result[i] = r1 + r2;
    }
    return result[l];
  }
}
