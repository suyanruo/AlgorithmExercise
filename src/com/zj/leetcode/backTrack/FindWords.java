package com.zj.leetcode.backTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ZhangJian on 2021/9/16.
 * 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * ref: https://leetcode-cn.com/problems/word-search-ii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hui-s-am8f/
 */
public class FindWords {
    class Solution {
        private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        private int m, n;
        private boolean[][] vis = new boolean[13][13];
        private List<String> ans = new ArrayList<>();
        private Set<String> set = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            for (String word : words) {
                set.add(word);
            }
            m = board.length;
            n = board[0].length;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    vis[i][j] = true;
                    sb.append(board[i][j]);
                    dfs(board, i, j, sb);
                    vis[i][j] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            return ans;
        }

        private void dfs(char[][] board, int x, int y, StringBuilder sb) {
            if (sb.length() > 10) return;
            if (set.contains(sb.toString())) {
                ans.add(sb.toString());
                set.remove(sb.toString());
            }
            for (int[] d : dirs) {
                int dx = d[0] + x;
                int dy = d[1] + y;
                if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
                if (vis[dx][dy]) continue;
                vis[dx][dy] = true;
                sb.append(board[dx][dy]);
                dfs(board, dx, dy, sb);
                vis[dx][dy] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    class Solution2 {
        class TrieNodeV2 {
            String s;
            TrieNodeV2[] tns = new TrieNodeV2[26];
        }

        private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        private int m, n;
        private boolean[][] vis = new boolean[13][13];
        private List<String> ans = new ArrayList<>();
        private Set<String> set = new HashSet<>();
        private TrieNodeV2 root = new TrieNodeV2();

        private void insert(String s) {
            TrieNodeV2 n = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (n.tns[u] == null) {
                    n.tns[u] = new TrieNodeV2();
                }
                n = n.tns[u];
            }
            n.s = s;
        }

        public List<String> findWords(char[][] board, String[] words) {
            m = board.length;
            n = board[0].length;
            for (String word : words) {
                insert(word);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int u = board[i][j] - 'a';
                    if (root.tns[u] != null) {
                        vis[i][j] = true;
                        dfs(board, i, j, root.tns[u]);
                        vis[i][j] = false;
                    }
                }
            }
            ans.addAll(set);
            return ans;
        }

        private void dfs(char[][] board, int x, int y, TrieNodeV2 node) {
            if (node.s != null) set.add(node.s);
            for (int[] d : dirs) {
                int dx = d[0] + x, dy = d[1] + y;
                if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
                if (vis[dx][dy]) continue;
                int u = board[dx][dy] - 'a';
                if (node.tns[u] != null) {
                    vis[dx][dy] = true;
                    dfs(board, dx, dy, node.tns[u]);
                    vis[dx][dy] = false;
                }
            }
        }
    }
}
