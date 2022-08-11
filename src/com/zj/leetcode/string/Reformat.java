package com.zj.leetcode.string;

/**
 * @author: zhangjian
 * @date: 2022/8/11 10:58
 * @description: 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 * 链接：https://leetcode.cn/problems/reformat-the-string
 * ref: https://leetcode.cn/problems/reformat-the-string/solution/by-ac_oier-uk8z/
 */
public class Reformat {
    public String reformat(String s) {
        StringBuilder digit = new StringBuilder(), album = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isDigit(c)) digit.append(c);
            else album.append(c);
        }
        int m = digit.length(), n = album.length();
        if (Math.abs(m - n) > 1) return "";
        StringBuilder sb = new StringBuilder();
        while (m + n > 0) {
            if (m > n) sb.append(digit.charAt(--m));
            else if (n > m) sb.append(album.charAt(--n));
            else {
                if (sb.length() > 0 && isDigit(sb.charAt(sb.length() - 1))) sb.append(album.charAt(--n));
                else sb.append(digit.charAt(--m));
            }
        }
        return sb.toString();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
