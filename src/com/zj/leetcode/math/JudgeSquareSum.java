package com.zj.leetcode.math;

/**
 * Created by ZhangJian on 2021/4/28.
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * ref: https://leetcode-cn.com/problems/sum-of-square-numbers/solution/gong-shui-san-xie-yi-ti-san-jie-mei-ju-s-7qi5/
 */
public class JudgeSquareSum {
    public class Solution {
        public boolean judgeSquareSum(int c) {
            int min = 0, max = (int) Math.sqrt(c);
            while (min <= max) {
                if (Math.pow(min, 2) + Math.pow(max, 2) == c) {
                    return true;
                }
                min++;
                max = (int) Math.sqrt(c - Math.pow(min, 2));
            }
            return false;
        }
    }

    public class Solution2 {
        public boolean judgeSquareSum(int c) {
            int a = 0, b = (int) Math.sqrt(c);
            while (a <= b) {
                int cur = a * a + b * b;
                if (cur > c) {
                    b--;
                } else if (cur < c) {
                    a++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
