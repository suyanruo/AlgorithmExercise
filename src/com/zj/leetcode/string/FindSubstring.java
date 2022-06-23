package com.zj.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhangjian
 * @date: 2022/6/23 10:16
 * @description: 串联所有单词的子串
 * 给定一个字符串s和一些 长度相同 的单词words 。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑words中单词串联的顺序。
 *
 * 链接：https://leetcode.cn/problems/substring-with-concatenation-of-all-words
 * 参考：https://leetcode.cn/problems/substring-with-concatenation-of-all-words/solution/chuan-lian-suo-you-dan-ci-de-zi-chuan-by-244a/
 */
public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) break;
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                String w = s.substring(i + j * n, i + (j + 1) * n);
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) - 1);
                if (map.get(word) == 0) map.remove(word);
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String w = s.substring(start + (m - 1) * n, start + m * n);
                    map.put(w, map.getOrDefault(w, 0) + 1);
                    if (map.get(w) == 0) map.remove(w);
                    w = s.substring(start - n, start);
                    map.put(w, map.getOrDefault(w, 0) - 1);
                    if (map.get(w) == 0) map.remove(w);
                }
                if (map.isEmpty()) result.add(start);
            }
        }
        return result;
    }
}
