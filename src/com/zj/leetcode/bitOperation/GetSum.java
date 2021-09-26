package com.zj.leetcode.bitOperation;

/**
 * Created by ZhangJian on 2021/9/26.
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 * 链接: https://leetcode-cn.com/problems/sum-of-two-integers/
 * ref: https://leetcode-cn.com/problems/sum-of-two-integers/solution/
 */
public class GetSum {
    public int getSum(int a, int b) {
        int ans = 0;
        int t = 0;
        for (int i = 0; i < 32; i++) {
            int u1 = (a >> i) & 1, u2 = (b >> i) & 1;
            if (u1 == 1 && u2 == 1) {
                ans |= t << i;
                t = 1;
            } else if (u1 == 1 || u2 == 1) {
                ans |= (1 ^ t) << i;
            } else {
                ans |= t << i;
                t = 0;
            }
        }
        return ans;
    }
}
