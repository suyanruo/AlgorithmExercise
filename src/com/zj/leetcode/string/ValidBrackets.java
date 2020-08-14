package com.zj.leetcode.string;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class ValidBrackets {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char cur, out;
        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                out = stack.pop();
                if (out == '(' && cur == ')') continue;
                else if (out == '[' && cur == ']') continue;
                else if (out == '{' && cur == '}') continue;
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
