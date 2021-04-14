package com.zj.model;

/**
 * Created on 4/14/21.
 * 前缀树节点
 */

public class TrieNode {
  public boolean isEnd;
  public TrieNode[] next = new TrieNode[26];
}
