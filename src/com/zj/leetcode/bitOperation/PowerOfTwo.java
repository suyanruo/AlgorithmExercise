package com.zj.leetcode.bitOperation;

/**
 * Created by ZhangJian on 2021/5/31.
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 *
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * ref: https://leetcode-cn.com/problems/power-of-two/solution/gong-shui-san-xie-2-de-mi-by-ac_oier-qm6e/
 */
public class PowerOfTwo {
    public class Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & -n) == n;
        }
    }

    public class Solution2 {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            while (n % 2 == 0) {
                n /= 2;
            }
            return n == 1;
        }
    }
}
