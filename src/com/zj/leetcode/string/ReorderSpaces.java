package com.zj.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangjian
 * @date: 2022/9/7 15:38
 * @description: 重新排列单词间的空格
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 * 返回 重新排列空格后的字符串 。
 *
 * 链接：https://leetcode.cn/problems/rearrange-spaces-between-words
 * ref: https://leetcode.cn/problems/rearrange-spaces-between-words/solution/by-ac_oier-0f5h/
 */
public class ReorderSpaces {
    public String reorderSpaces(String text) {
        int len = text.length(), blockSize = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ' && ++blockSize >= 0) continue;
            int j = i;
            while (j < len && text.charAt(j) != ' ') j++;
            list.add(text.substring(i, j));
            i = j - 1;
        }
        int count = list.size();

        StringBuilder sb = new StringBuilder();
        if (count == 1) {
            sb.append(list.get(0));
            for (int i = 0; i < blockSize; i++) sb.append(" ");
        } else {
            int n1 = blockSize / (count - 1), n2 = blockSize % (count - 1);
            String s1 = "", s2 = "";
            for (int i = 0; i < n1; i++) s1 += " ";
            for (int j = 0; j < n2; j++) s2 += " ";
            for (int i = 0; i < count - 1; i++) {
                sb.append(list.get(i)).append(s1);
            }
            sb.append(list.get(count - 1)).append(s2);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new ReorderSpaces().reorderSpaces("  this   is  a sentence ");
    }
}
