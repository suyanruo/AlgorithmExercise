package com.zj.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/7/1 08:58
 * @description: 质数排列
 * 请你帮忙给从 1 到 n的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 * 由于答案可能会很大，所以请你返回答案 模 mod10^9 + 7之后的结果即可。
 *
 * 链接：https://leetcode.cn/problems/prime-arrangements
 * 参考：https://leetcode.cn/problems/prime-arrangements/solution/by-ac_oier-t3lk/
 */
public class NumPrimeArrangements {
    int MOD = (int) (1e9 + 7);
    static List<Integer> list = new ArrayList<>();

    public int numPrimeArrangements(int n) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid) <= n) l = mid;
            else r = mid - 1;
        }
        int a = r + 1, b = n - a;
        long result = 1;
        for (int i = a; i > 1; i--) result = result * i % MOD;
        for (int i = b; i > 1; i--) result = result * i % MOD;
        return (int) result;
    }

    static  {
        for (int i = 2; i <= 100; i++) {
            boolean ok = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) list.add(i);
        }
    }
}
