package com.zj.leetcode.dynamic;

import java.util.stream.LongStream;

/**
 * Created by ZhangJian on 2021/8/18.
 * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：8
 * 解释：
 * 有 8 种长度为 2 的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
 *
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-ii
 * ref: https://leetcode-cn.com/problems/student-attendance-record-ii/solution/tong-ge-lai-shua-ti-la-yi-ti-liu-jie-dfs-s5fa/
 */
public class CheckRecord {
    public class Solution {
        private int MOD = (int) (1e9 + 7);

        public int checkRecord(int n) {
            long[][][] f = new long[n][2][3];
            f[0][0][0] = 1;
            f[0][1][0] = 1;
            f[0][0][1] = 1;

            for (int i = 1; i < n; i++) {
                // P
                f[i][0][0] = (f[i - 1][0][0] + f[i - 1][0][1] + f[i - 1][0][2]) % MOD;
                f[i][1][0] = (f[i - 1][1][0] + f[i - 1][1][1] + f[i - 1][1][2]) % MOD;
                // A
                f[i][1][0] = (f[i][1][0] + f[i - 1][0][0] + f[i - 1][0][1] + f[i - 1][0][2]) % MOD;
                // L
                f[i][0][1] = f[i - 1][0][0];
                f[i][0][2] = f[i - 1][0][1];
                f[i][1][1] = f[i - 1][1][0];
                f[i][1][2] = f[i - 1][1][1];
            }
            long ans = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    ans = (ans + f[n - 1][i][j]) % MOD;
                }
            }
            return (int) ans;
        }
    }

    public class Solution2 {
        private int MOD = (int) (1e9 + 7);

        public int checkRecord(int n) {
            long[][] f = new long[2][3];
            f[0][0] = 1;
            f[1][0] = 1;
            f[0][1] = 1;

            for (int i = 1; i < n; i++) {
                long[][] newF = new long[2][3];
                // P
                newF[0][0] = (f[0][0] + f[0][1] + f[0][2]) % MOD;
                newF[1][0] = (f[1][0] + f[1][1] + f[1][2]) % MOD;
                // A
                newF[1][0] = (newF[1][0] + f[0][0] + f[0][1] + f[0][2]) % MOD;
                // L
                newF[0][1] = f[0][0];
                newF[0][2] = f[0][1];
                newF[1][1] = f[1][0];
                newF[1][2] = f[1][1];
                f = newF;
            }
            long ans = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    ans = (ans + f[i][j]) % MOD;
                }
            }
            return (int) ans;
        }
    }

    public class Solution3 {
        private int MOD = (int) (1e9 + 7);

        public int checkRecord(int n) {
            long[][] f = new long[2][6];
            // 0,0->0  1,0->1  0,1->2  0,2->3  1,1->4  1,2->5
            f[0][0] = 1; // A:0;P:0
            f[0][1] = 1; // A:1;P:0
            f[0][2] = 1; // A:0;P:1

            for (int i = 1; i < n; i++) {
                int cur = i & 1, last = (i - 1) & 1;
                // P
                f[cur][0] = (f[last][0] + f[last][2] + f[last][3]) % MOD;
                f[cur][1] = (f[last][1] + f[last][4] + f[last][5]) % MOD;
                // A
                f[cur][1] = (f[cur][1] + f[last][0] + f[last][2] + f[last][3]) % MOD;
                // L
                f[cur][2] = f[last][0];
                f[cur][3] = f[last][2];
                f[cur][4] = f[last][1];
                f[cur][5] = f[last][4];
            }
            long ans = 0;
            for (int i = 0; i < 6; i++) {
                ans = (ans + f[(n - 1) & 1][i]) % MOD;
            }
            return (int) ans;
        }
    }
}
