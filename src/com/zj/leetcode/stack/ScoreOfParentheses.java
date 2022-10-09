package com.zj.leetcode.stack;

import java.util.Stack;

/**
 * @author: zhangjian
 * @date: 2022/10/9 14:57
 * @description: 括号的分数
 * 给定一个平衡括号字符串S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得A + B分，其中 A 和 B 是平衡括号字符串。
 * (A) 得2 * A分，其中 A 是平衡括号字符串。
 *
 * 链接：https://leetcode.cn/problems/score-of-parentheses
 * ref: https://leetcode.cn/problems/score-of-parentheses/solution/by-ac_oier-0mhz/
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        int n = s.length(), idx = 0;
        char[] cs = s.toCharArray();
        while (idx < n) {
            if (cs[idx] == '(') {
                stack.add(String.valueOf("("));
            } else {
                String c = stack.pop();
                if (c == "(") {
                    if (!stack.isEmpty() && stack.peek() != "(") {
                        String num = stack.pop();
                        stack.add(String.valueOf(Integer.parseInt(num) + 1));
                    } else {
                        stack.add(String.valueOf(1));
                    }
                } else {
                    stack.pop();
                    int num = Integer.parseInt(c);
                    if (!stack.isEmpty() && stack.peek() != "(") {
                        String s2 = stack.pop();
                        if (s2 != "(") num = num * 2 + Integer.parseInt(s2);
                    }
                    stack.add(String.valueOf(num));
                }
                System.out.println(stack.toString());
            }
            idx++;
        }
        return Integer.parseInt(stack.peek());
    }
}
