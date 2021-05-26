package com.zj.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by ZhangJian on 2021/5/26.
 * 给出一个字符串s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * ref: https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/solution/gong-shui-san-xie-shi-yong-shuang-duan-d-r35q/
 */
public class ReverseParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseParentheses("(abcd)");
    }

    public static class Solution {
        public String reverseParentheses(String s) {
            char[] cs = s.toCharArray();
            Deque<Character> deque = new ArrayDeque<>();
            Deque<Character> temp = new ArrayDeque<>();
            int count = 0;
            for (char c : cs) {
                if (c != ')') {
                    deque.add(c);
                } else {
                    while (deque.peekLast() != '(') {
                        temp.add(deque.pollLast());
                    }
                    if (!deque.isEmpty()) {
                        count++;
                        deque.pollLast();
                    }
                    while (!temp.isEmpty()) {
                        deque.add(temp.pollFirst());
                    }
                }
            }
            StringBuilder ans = new StringBuilder();
            while (!deque.isEmpty()) {
                ans.append(deque.pop());
            }
            System.out.println(ans);
            return ans.toString();
        }
    }
}
