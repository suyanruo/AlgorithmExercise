package com.zj.leetcode.tree;

import com.zj.leetcode.TreeNode;

import java.util.Stack;

/**
 * Created on 2020/10/12.
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumDifference {
  public int getMinimumDifference(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    TreeNode pre = null;
    int dif = Integer.MAX_VALUE;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      if (pre != null) {
        dif = Math.min(dif, node.val - pre.val);
      }
      pre = node;
      node = node.right;
    }
    return dif;
  }
}
