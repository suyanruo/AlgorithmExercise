package com.zj.leetcode.tree;

import com.zj.model.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/7/7 13:58
 * @description: 单词替换
 * 在英语中，我们有一个叫做词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 * 链接：https://leetcode.cn/problems/replace-words
 * https://leetcode.cn/problems/replace-words/solution/by-ac_oier-jecf/
 */
public class ReplaceWords {
    private TrieNode root;

    private void add(String s) {
        if (root == null) root = new TrieNode();
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new TrieNode();
            }
            cur = cur.next[idx];
        }
        cur.isEnd = true;
    }

    private String query(String s) {
        TrieNode cur = root;
        int count = 0;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (cur.isEnd) return s.substring(0, count);
            if (cur.next[idx] == null) break;
            cur = cur.next[idx];
            count++;
        }
        return s;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String pre : dictionary) {
            add(pre);
        }
        String[] senWords = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : senWords) {
            stringBuilder.append(query(word)).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    public static void main(String[] args) {
        ReplaceWords words = new ReplaceWords();
        List<String> dic = new ArrayList<>();
        dic.add("cat");
        dic.add("bat");
        dic.add("rat");
        System.out.println(words.replaceWords(dic, "the cattle was rattled by the battery"));
    }
}
