package com.zj.leetcode.math;

/**
 * Created by ZhangJian on 2021/6/18.
 * 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称k（k>=2）是 n 的一个好进制。
 *
 * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
 *
 * 示例 1：
 *
 * 输入："13"
 * 输出："3"
 * 解释：13 的 3 进制是 111。
 *
 * 链接：https://leetcode-cn.com/problems/smallest-good-base
 * ref: https://leetcode-cn.com/problems/smallest-good-base/solution/gong-shui-san-xie-xiang-jie-ru-he-fen-xi-r94g/
 */
public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long m = Long.parseLong(n);
        int max = (int) (Math.log(m) / Math.log(2) + 1);
        for (int val = max; val > 2; val--) {
            long k = (long) Math.pow(m, 1.0 / (val - 1));
            long res = 0;
            for (int i = 0; i < val; i++) {
                res = res * k + 1;
            }
            if (res == m) {
                return String.valueOf(k);
            }
        }
        return String.valueOf(m - 1);
    }
}
