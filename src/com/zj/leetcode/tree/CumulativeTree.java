package com.zj.leetcode.tree;

import com.zj.model.TreeNode;

/**
 * Created on 2020/9/21.
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 */
public class CumulativeTree {
  private int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    dfs(root);
    return root;
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.right != null) {
      dfs(root.right);
    }
    sum += root.val;
    root.val = sum;
    if (root.left != null) {
      dfs(root.left);
    }
  }
}
