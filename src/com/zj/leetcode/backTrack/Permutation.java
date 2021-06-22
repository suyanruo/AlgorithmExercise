package com.zj.leetcode.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ZhangJian on 2021/6/22.
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * ref: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/gong-shui-san-xie-tong-yong-shi-xian-qu-4jbkj/
 */
public class Permutation {
    private int N = 10;
    private boolean[] visit = new boolean[N];

    public class Solution {
        private HashSet<String> set = new HashSet<>();

        public String[] permutation(String s) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            dfs(cs, 0, "");
            String[] ans = new String[set.size()];
            int index = 0;
            for (String str : set) {
                ans[index++] = str;
            }
            return ans;
        }

        private void dfs(char[] cs, int cur, String sorted) {
            int n = cs.length;
            if (sorted.length() == n) {
                set.add(sorted);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(cs, i + 1, sorted + cs[i]);
                    visit[i] = false;
                }
            }
        }
    }

    public class Solution2 {
        private ArrayList<String> list = new ArrayList<>();

        public String[] permutation(String s) {
            char[] cs = s.toCharArray();
            dfs(cs, 0, "");
            String[] ans = new String[list.size()];
            int index = 0;
            for (String str : list) {
                ans[index++] = str;
            }
            return ans;
        }

        private void dfs(char[] cs, int u, String cur) {
            int n = cs.length;
            if (u == n) {
                list.add(cur);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (i > 0 && !visit[i - 1] && cs[i] == cs[i - 1]) {
                    continue;
                }
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(cs, u + 1, cur + cs[i]);
                    visit[i] = false;
                }
            }
        }
    }
}
