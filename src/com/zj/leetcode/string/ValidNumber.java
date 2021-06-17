package com.zj.leetcode.string;

/**
 * Created by ZhangJian on 2021/6/17.
 * 有效数字（按顺序）可以分成以下几个部分：
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 *
 * 小数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 *
 * 整数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分有效数字列举如下：
 *
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：
 *
 * ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 *
 * 链接：https://leetcode-cn.com/problems/valid-number
 * ref: https://leetcode-cn.com/problems/valid-number/solution/gong-shui-san-xie-zi-fu-chuan-mo-ni-by-a-7cgc/
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        char[] cs = s.toCharArray();
        int l = cs.length;
        int index = -1;
        for (int i = 0; i < l; i++) {
            if (cs[i] == 'e' || cs[i] == 'E') {
                if (index != -1) {
                    return false;
                }
                index = i;
            }
        }
        boolean ans = true;
        if (index == -1) {
            ans &= check(cs, 0, l - 1, false);
        } else {
            ans &= check(cs, 0, index - 1, false);
            ans &= check(cs, index + 1, l - 1, true);
        }
        return ans;
    }

    private boolean check(char[] cs, int start, int end, boolean needInteger) {
        if (start > end) {
            return false;
        }
        if (cs[start] == '+' || cs[start] == '-') {
            start++;
        }
        boolean hasDot = false, hasNum = false;
        for (int i = start; i <= end; i++) {
            if (cs[i] == '.') {
                if (needInteger || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (cs[i] >= '0' && cs[i] <= '9') {
                hasNum = true;
            } else {
                return false;
            }
        }
        return hasNum;
    }
}
