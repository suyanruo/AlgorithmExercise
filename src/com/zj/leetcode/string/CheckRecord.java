package com.zj.leetcode.string;

/**
 * Created by ZhangJian on 2021/8/17.
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 *
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * ref: https://leetcode-cn.com/problems/student-attendance-record-i/solution/gong-shui-san-xie-jian-dan-mo-ni-ti-by-a-hui7/
 */
public class CheckRecord {
    public boolean checkRecord(String s) {
        char[] cs = s.toCharArray();
        int countA = 0, countL = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'P') continue;
            if (cs[i] == 'A') {
                countA++;
                if (countA >= 2) return false;
            } else if (cs[i] == 'L') {
                if (i > 0 && cs[i] != cs[i - 1] || i == 0) {
                    countL = 0;
                }
                countL++;
                if (countL >= 3) return false;
            }
        }
        return true;
    }
}
