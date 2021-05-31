package com.zj.leetcode.bitOperation;

/**
 * Created by ZhangJian on 2021/5/31.
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 *
 * 链接：https://leetcode-cn.com/problems/power-of-four
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0, index = 0;
        // 4^x => 2^2x，所以分别对4的幂次方每位做与1操作，只有一位与1不为0，且该位必须是偶数位
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
                if (index % 2 != 0 || count > 1) {
                    return false;
                }
            }
            n = n >> 1;
            index++;
        }
        return true;
    }
}
