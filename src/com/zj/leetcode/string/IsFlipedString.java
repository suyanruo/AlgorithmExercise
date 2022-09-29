package com.zj.leetcode.string;

/**
 * @author: zhangjian
 * @date: 2022/9/29 15:32
 * @description: 面试题 01.09. 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 * 链接：https://leetcode.cn/problems/string-rotation-lcci
 * ref: https://leetcode.cn/problems/string-rotation-lcci/solution/by-ac_oier-2wo1/
 */
public class IsFlipedString {
    private int N = 200010, P = 13131;

    public boolean isFlipedString(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n) return false;
        int[] h = new int[N], p = new int[N];
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s2.charAt(i - 1);
        }
        int t = h[n];
        s1 = s1 + s1;
        p[0] = 1;
        for (int i = 1; i <= 2 * n; i++) {
            h[i] = h[i - 1] * P + s1.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        for (int i = 1; i + n - 1 <= 2 * n; i++) {
            int j = i + n - 1, cur = h[j] - h[i - 1] * p[j - i + 1];
            if (cur == t) return true;
        }
        return false;
    }
}
