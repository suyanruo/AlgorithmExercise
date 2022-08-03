package com.zj.leetcode.sort;

import java.util.Arrays;

/**
 * @author: zhangjian
 * @date: 2022/8/3 18:44
 * @description: 有序队列
 * 给定一个字符串 s 和一个整数 k。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串。
 *
 * 链接：https://leetcode.cn/problems/orderly-queue
 * ref: https://leetcode.cn/problems/orderly-queue/solution/by-ac_oier-443m/
 */
public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        char[] cs = s.toCharArray();
        if (k == 1) {
            int i = 0, j = 1, l = 0, n = s.length();
            while (i < n && j < n && k < n) {
                char a = cs[(i + l) % n], b = cs[(j + l) % n];
                if (a == b) l++;
                else {
                    if (a > b) i += l + 1;
                    else j += l + 1;
                    if (i == j) i++;
                    l = 0;
                }
            }
            int start = Math.min(i, j);
            return s.substring(start) + s.substring(0, start);
        } else {
            Arrays.sort(cs);
            return new String(cs);
        }
    }
}
