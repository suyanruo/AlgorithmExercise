package com.zj.leetcode.tree;

import com.zj.model.TrieNode;

/**
 * Created on 4/14/21.
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * 
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * ref: https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/trie-tree-de-shi-xian-gua-he-chu-xue-zhe-by-huwt/
 */

public class Trie {
  private TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.next[c - 'a'] == null) {
        node.next[c - 'a'] = new TrieNode();
      }
      node = node.next[c - 'a'];
    }
    node.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode current = root;
    for (char c : word.toCharArray()) {
      if (current.next[c - 'a'] == null) {
        return false;
      }
      current = current.next[c - 'a'];
    }
    return current.isEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode current = root;
    for (char c : prefix.toCharArray()) {
      if (current.next[c - 'a'] == null) {
        return false;
      }
      current = current.next[c - 'a'];
    }
    return true;
  }
}
