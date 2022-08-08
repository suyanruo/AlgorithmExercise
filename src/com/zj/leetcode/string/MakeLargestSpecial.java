package com.zj.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/8/8 13:47
 * @description: 特殊的二进制序列
 * 特殊的二进制序列是具有以下两个性质的二进制序列：
 * 0 的数量与 1 的数量相等。
 * 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。
 * 给定一个特殊的二进制序列S，以字符串形式表示。定义一个操作 为首先选择S的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
 * 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
 *
 * 链接：https://leetcode.cn/problems/special-binary-string
 * ref: https://leetcode.cn/problems/special-binary-string/solution/by-ac_oier-cz6h/
 */
public class MakeLargestSpecial {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) return s;
        char[] cs = s.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0, j = 0, k = 0; i < cs.length; i++) {
            k += cs[i] == '1' ? 1 : -1;
            if (k == 0) {
                list.add("1" + makeLargestSpecial(s.substring(j + 1, i)) + "0");
                j = i + 1;
            }
        }
        System.out.println("list:" + list.size());
        Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder builder = new StringBuilder();
        for (String ss : list) builder.append(ss);
        return builder.toString();
    }
}
