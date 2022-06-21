package com.zj.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhangjian
 * @date: 2022/6/21 11:22
 * @description: 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 参考：https://mp.weixin.qq.com/s/5wDNgy1yjIBJg7CaDtd42g
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                char r = s.charAt(i);
                map.put(r, map.get(r) - 1);
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
