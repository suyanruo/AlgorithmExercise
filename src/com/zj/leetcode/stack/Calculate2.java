package com.zj.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created on 3/11/21.
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * 链接：https://leetcode-cn.com/problems/basic-calculator-ii
 */

public class Calculate2 {
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
      } else if (isNumber(cs[i])) {
        int u = 0;
        int j = i;
        while (j < len && isNumber(cs[j])) {
          u = u * 10 + (cs[j++] - '0');
        }
        numStack.addLast(u);
        i = j - 1;
        if (!opStack.isEmpty() && (opStack.peekLast() == '*' || opStack.peekLast() == '/')) {
          calNum(numStack, opStack);
        }
      } else {
        if (cs[i] != '*' && cs[i] != '/') {
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
    System.out.println("i1: " + first + ", i2: " + second + ", op: " + op);
    switch (op) {
      case '+':
        numStack.addLast(first + second);
        break;
      case '-':
        numStack.addLast(first - second);
        break;
      case '*':
        numStack.addLast(first * second);
        break;
      case '/':
        numStack.addLast(first / second);
        break;
    }
  }

  private boolean isNumber(char c) {
    return Character.isDigit(c);
  }
}
