package com.zj.leetcode.array;

/**
 * @author: zhangjian
 * @date: 2022/7/4 08:50
 * @description: 下一个更大元素 III
 * 给你一个正整数n ，请你找出符合条件的最小整数，其由重新排列 n中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 *
 * 链接：https://leetcode.cn/problems/next-greater-element-iii
 * 参考：https://leetcode.cn/problems/next-greater-element-iii/solution/by-ac_oier-99bj/
 */
public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        int len = cs.length, idx = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (cs[i + 1] > cs[i]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return -1;
        for (int i = len - 1; i > idx; i--) {
            if (cs[i] > cs[idx]) {
                swap(cs, i, idx);
                break;
            }
        }
        for (int l = idx + 1, r = len - 1; l < r; l++, r--) {
            swap(cs, l, r);
        }
        long val = Long.parseLong(String.valueOf(cs));
        if (val > Integer.MAX_VALUE) return -1;
        else return (int) val;
    }

    private void swap(char[] cs, int a, int b) {
        char c = cs[a];
        cs[a] = cs[b];
        cs[b] = c;
    }
}
