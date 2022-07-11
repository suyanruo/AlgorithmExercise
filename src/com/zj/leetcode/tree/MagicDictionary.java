package com.zj.leetcode.tree;

/**
 * @author: zhangjian
 * @date: 2022/7/11 19:11
 * @description: 实现一个魔法字典
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 *
 * 实现 MagicDictionary 类：
 *
 * MagicDictionary() 初始化对象
 * void buildDict(String[]dictionary) 使用字符串数组dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *
 * 链接：https://leetcode.cn/problems/implement-magic-dictionary
 * ref: https://leetcode.cn/problems/implement-magic-dictionary/solution/by-ac_oier-a01l/
 */
public class MagicDictionary {
    int N = 100 * 100, M = 26, idx = 0;
    int[][] tri = new int[N][M];
    boolean[] isEnd = new boolean[N * M];

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) add(s);
    }

    private void add(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (tri[p][u] == 0) tri[p][u] = ++idx;
            p = tri[p][u];
        }
        isEnd[p] = true;
    }

    public boolean search(String searchWord) {
        return query(searchWord, 0, 0, 1);
    }

    private boolean query(String s, int idx, int p, int limit) {
        if (limit < 0) return false;
        if (idx == s.length()) return isEnd[p] && limit == 0;
        int u = s.charAt(idx) - 'a';
        for (int i = 0; i < 26; i++) {
            if (tri[p][i] == 0) continue;
            if (query(s, idx + 1, tri[p][i], i != u ? limit - 1 : limit)) return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */