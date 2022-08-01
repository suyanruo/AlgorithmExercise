package com.zj.leetcode.simulation;

/**
 * @author: zhangjian
 * @date: 2022/8/1 18:38
 * @description: 生成每种字符都是奇数个的字符串
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 *
 * 链接：https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts
 * ref: https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/solution/by-ac_oier-i74n/
 */
public class GenerateTheString {
    public String generateTheString(int n) {
        StringBuilder s = new StringBuilder();
        if (n % 2 == 0 && n-- >= 1) s.append("a");
        while (n-- > 0) s.append("b");
        return s.toString();
    }
}
