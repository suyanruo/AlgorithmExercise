package com.zj.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created on 3/10/21.
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 *
 * 链接：https://leetcode-cn.com/problems/basic-calculator/solution/shuang-zhan-jie-jue-tong-yong-biao-da-sh-olym/
 */

public class Calculate {
  public int calculate(String s) {
    char[] cs = s.toCharArray();
    int len = cs.length;
    Deque<Integer> numStack = new ArrayDeque<>();
    Deque<Character> opStack = new ArrayDeque<>();
    numStack.addLast(0);
    for (int i = 0; i < len; i++) {
      if (cs[i] == ' ') {
        continue;
      }
      if (cs[i] == '(') {
        opStack.addLast(cs[i]);
      } else if (cs[i] == ')') {
        while (!opStack.isEmpty()) {
          if (opStack.peekLast() != '(') {
            calNum(numStack, opStack);
          } else {
            opStack.pollLast();
            break;
          }
        }
      } else if (isNum(cs[i])) {
        int u = 0;
        int j = i;
        while (j < len && isNum(cs[j])) {
          u = u * 10 + (cs[j++] - '0');
        }
        numStack.addLast(u);
        i = j - 1;
      } else {
        while (!opStack.isEmpty() && opStack.peekLast() != '(') {
          calNum(numStack, opStack);
        }
        opStack.addLast(cs[i]);
      }
    }
    while (!opStack.isEmpty()) {
      calNum(numStack, opStack);
    }
    return numStack.pollLast();
  }

  private void calNum(Deque<Integer> numStack, Deque<Character> opStack) {
    if (numStack.isEmpty() || numStack.size() < 2) {
      return;
    }
    if (opStack.isEmpty()) {
      return;
    }
    int second = numStack.pollLast(), first = numStack.pollLast();
    char op = opStack.pollLast();
    int temp = op == '+' ? first + second : first - second;
    numStack.addLast(temp);
  }

  private boolean isNum(char c) {
    return Character.isDigit(c);
  }
}
