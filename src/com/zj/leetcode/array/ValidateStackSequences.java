package com.zj.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: zhangjian
 * @date: 2022/8/31 10:42
 * @description:  验证栈序列
 * 给定pushed和popped两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false。
 *
 * 链接：https://leetcode.cn/problems/validate-stack-sequences
 * ref: https://leetcode.cn/problems/validate-stack-sequences/solution/by-ac_oier-84qd/
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            deque.addLast(pushed[i]);
            while (!deque.isEmpty() && deque.peekLast() == popped[j] && ++j >= 0)
                deque.pollLast();
        }
        return deque.isEmpty();
    }
}
