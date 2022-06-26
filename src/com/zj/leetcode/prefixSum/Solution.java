package com.zj.leetcode.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author: zhangjian
 * @date: 2022/6/26 19:49
 * @description:
 * 给定一个整数 n 和一个 无重复 黑名单整数数组blacklist。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个未加入黑名单blacklist的整数。任何在上述范围内且不在黑名单blacklist中的整数都应该有 同等的可能性 被返回。
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 *
 * 实现Solution类:
 * Solution(int n, int[] blacklist)初始化整数 n 和被加入黑名单blacklist的整数
 * int pick()返回一个范围为 [0, n - 1] 且不在黑名单blacklist 中的随机整数
 *
 * 链接：https://leetcode.cn/problems/random-pick-with-blacklist
 * 参考：https://leetcode.cn/problems/random-pick-with-blacklist/solution/by-ac_oier-2rww/
 */
class Solution {
    List<int[]> list = new ArrayList<>();
    int[] sum = new int[100010];
    Random random = new Random();
    int sz;

    public Solution(int n, int[] blacklist) {
        Arrays.sort(blacklist);
        int m = blacklist.length;
        if (m == 0) {
            list.add(new int[]{0, n - 1});
        } else {
            if (blacklist[0] != 0) list.add(new int[]{0, blacklist[0] - 1});
            for (int i = 1; i < m; i++) {
                if (blacklist[i - 1] == blacklist[i] - 1) continue;
                list.add(new int[]{blacklist[i - 1] + 1, blacklist[i] - 1});
            }
            if (blacklist[m - 1] != n - 1) list.add(new int[]{blacklist[m - 1] + 1, n - 1});
        }
        sz = list.size();
        for (int i = 1; i <= sz; i++) {
            int[] tem = list.get(i - 1);
            sum[i] = sum[i - 1] + tem[1] - tem[0] + 1;
        }
    }

    public int pick() {
        int l = 1, r = sz;
        int val = random.nextInt(sum[sz]) + 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= val) r = mid;
            else l = mid + 1;
        }
        int[] in = list.get(r - 1);
        int b = in[1], end = sum[r];
        return b - (end - val);
    }
}