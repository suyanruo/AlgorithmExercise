package com.zj.leetcode.doublePointer;

/**
 * Created by ZhangJian on 2021/8/20.
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 *
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 *
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * ref: https://leetcode-cn.com/problems/reverse-string-ii/solution/gong-shui-san-xie-jian-dan-zi-fu-chuan-m-p88f/
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int l = 0, r = k - 1, t = 0;
        while (true) {
            if (l >= n) break;
            if (r >= n) r = n - 1;
            if (l < r) {
                swap(cs, l++, r--);
            } else {
                l = ++t * 2 * k;
                r = l + k - 1;
            }
        }
        return String.valueOf(cs);
    }

    private void swap(char[] cs, int s, int e) {
        char c = cs[s];
        cs[s] = cs[e];
        cs[e] = c;
    }
}
